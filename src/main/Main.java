package main;

import main.devices.LCD;
import main.devices.Printer;
import main.model.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Printer printer = msg -> System.out.println("-------Printer------\n" + msg);
        LCD lcd = new LCD() {
            @Override
            public void onProductDisplay(Product product) {
                System.out.println("LCD: " + product.toString());
            }

            @Override
            public void onProductNotFoundDisplay() {
                System.out.println("LCD: Product not found");
            }

            @Override
            public void onInvalidBarCodeDisplay() {
                System.out.println("LCD: Invalid bar-code");
            }

            @Override
            public void onTotalSumDisplay(String totalSum) {
                System.out.println("LCD: Total sum: " + totalSum);
            }
        };

        PointOfSale pointOfSale = new PointOfSale(printer, lcd);
        List<Product> mockProductsList = new ArrayList<>();
        mockProductsList.add(new Product("123451", "chicken", new BigDecimal("12.30")));
        mockProductsList.add(new Product("111451", "chicken", new BigDecimal("12.30")));
        mockProductsList.add(new Product("", "chicken", new BigDecimal("12.30")));

        mockProductsList.add(new Product("123452", "apple", new BigDecimal("15.35")));
        mockProductsList.add(new Product("123453", "ham", new BigDecimal("2.00")));
        mockProductsList.add(new Product("123454", "bread", new BigDecimal("33.30")));
        mockProductsList.add(new Product("234515", "butter", new BigDecimal("122.30")));
        mockProductsList.add(new Product("134525", "top", new BigDecimal("111.30")));
        mockProductsList.add(new Product("124525", "glass", new BigDecimal("12.35")));

        pointOfSale.onScanProccess(mockProductsList);
//        pointOfSale.onExit();

    }
}
