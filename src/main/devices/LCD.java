package main.devices;

import main.model.Product;

public interface LCD {
    void onProductDisplay(Product product);

    void onProductNotFoundDisplay();

    void onInvalidBarCodeDisplay();

    void onTotalSumDisplay(String totalSum);
}
