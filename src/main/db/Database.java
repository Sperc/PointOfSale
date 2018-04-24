package main.db;

import main.model.Product;

import java.math.BigDecimal;
import java.util.*;

public class Database {
    private List<Product> databaseProducts;

    public Database() {
        this.databaseProducts = new ArrayList<>();
        databaseProducts.add(new Product("123451", "chicken", new BigDecimal("12.30")));
        databaseProducts.add(new Product("123452", "apple", new BigDecimal("15.35")));
        databaseProducts.add(new Product("123453", "ham", new BigDecimal("2.00")));
        databaseProducts.add(new Product("123454", "bread", new BigDecimal("33.30")));
        databaseProducts.add(new Product("234515", "butter", new BigDecimal("122.30")));
        databaseProducts.add(new Product("134525", "top", new BigDecimal("111.30")));
        databaseProducts.add(new Product("124525", "glass", new BigDecimal("12.35")));
    }

    public List<Product> getDatabaseProducts() {
        return databaseProducts;
    }

    public void setDatabaseProducts(List<Product> databaseProducts) {
        this.databaseProducts = databaseProducts;
    }

    public Product gerProductByName(String code) {
        for (Product p : databaseProducts) {
            if (p.getCode().equals(code))
                return p;
        }
        return null;
    }
}
