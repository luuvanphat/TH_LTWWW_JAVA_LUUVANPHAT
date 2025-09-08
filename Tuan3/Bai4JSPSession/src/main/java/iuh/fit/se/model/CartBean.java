package iuh.fit.se.model;

import java.util.*;

public class CartBean {
    private Map<String, CartItemBean> items = new HashMap<>();

    public void addProduct(Product p, int qty) {
        if (items.containsKey(p.getId())) {
            CartItemBean item = items.get(p.getId());
            item.setQuantity(item.getQuantity() + qty);
        } else {
            items.put(p.getId(), new CartItemBean(p, qty));
        }
    }

    public void updateProduct(String id, int qty) {
        if (items.containsKey(id)) {
            CartItemBean item = items.get(id);
            item.setQuantity(qty);
        }
    }

    public void removeProduct(String id) {
        items.remove(id);
    }

    public Collection<CartItemBean> getItems() {
        return items.values();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public double getTotal() {
        return items.values().stream()
                .mapToDouble(i -> i.getProduct().getPrice() * i.getQuantity())
                .sum();
    }
}

