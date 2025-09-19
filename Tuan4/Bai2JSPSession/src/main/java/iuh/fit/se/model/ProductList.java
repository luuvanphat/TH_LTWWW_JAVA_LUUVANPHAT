package iuh.fit.se.model;

import java.util.*;

public class ProductList {
    private static final List<Product> products = new ArrayList<>();

    static {
        products.add(new Product("P1", "Laptop", 1500));
        products.add(new Product("P2", "Smartphone", 800));
        products.add(new Product("P3", "Headphone", 120));
    }

    public static List<Product> getAll() {
        return products;
    }

    public static Product getById(String id) {
        return products.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }
}

