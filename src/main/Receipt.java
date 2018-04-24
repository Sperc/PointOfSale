package main;

import main.model.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Receipt {
    private List<Product> productList;
    private BigDecimal totalSum;

    public Receipt() {
        productList = new ArrayList<>();
        totalSum = new BigDecimal(0.00);
    }

    public void add(Product product) {
        productList.add(product);
        totalSum = totalSum.add(product.getPrice());
    }

    public List<Product> getProductList() {
        return productList;
    }

    @Override
    public String toString() {
        String result = "";
        for (Product product : productList) {
            result += product.getCode() + " " + product.getName() + " " + product.getPrice() + "\n";
        }
        result += "Total: " + totalSum;
        return result;
    }

    public BigDecimal getTotalSum() {
        return totalSum;
    }
}
