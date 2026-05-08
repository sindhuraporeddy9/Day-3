package com.TargetHomePage.service;

import com.TargetHomePage.model.CartItem;
import com.TargetHomePage.model.Product;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class CartService {
    private static final String CART_SESSION_KEY = "shoppingCart";

    @SuppressWarnings("unchecked")
    public List<CartItem> getCart(HttpSession session) {
        Object stored = session.getAttribute(CART_SESSION_KEY);
        if (stored instanceof List<?>) {
            return (List<CartItem>) stored;
        }

        List<CartItem> cart = new ArrayList<>();
        session.setAttribute(CART_SESSION_KEY, cart);
        return cart;
    }

    public void addProduct(HttpSession session, Product product) {
        List<CartItem> cart = getCart(session);
        for (CartItem item : cart) {
            if (item.getProduct().getId() == product.getId()) {
                cart.set(cart.indexOf(item), new CartItem(item.getProduct(), item.getQuantity() + 1));
                return;
            }
        }
        cart.add(new CartItem(product, 1));
    }

    public void removeProduct(HttpSession session, int productId) {
        List<CartItem> cart = getCart(session);
        Iterator<CartItem> iterator = cart.iterator();
        while (iterator.hasNext()) {
            CartItem item = iterator.next();
            if (item.getProduct().getId() == productId) {
                iterator.remove();
                break;
            }
        }
    }

    public int getCartSize(HttpSession session) {
        return getCart(session).stream().mapToInt(CartItem::getQuantity).sum();
    }

    public double getCartTotal(HttpSession session) {
        return getCart(session).stream().mapToDouble(CartItem::getTotalPrice).sum();
    }
}
