package main;

import main.dao.ProductDao;
import main.dao.implementation.ProductDaoImpl;
import main.devices.LCD;
import main.devices.Printer;
import main.devices.Scanner;
import main.model.Product;

import java.util.List;

public class PointOfSale implements Scanner {
    private ProductDao productDao;
    private Printer printer;
    private LCD lcd;
    private Receipt receipt;

    public PointOfSale(Printer printer, LCD lcd) {
        this.printer = printer;
        this.lcd = lcd;
        receipt = new Receipt();
        productDao = new ProductDaoImpl();
    }

    public void onScanProccess(List<Product> products) {
        for (Product p : products) {
            scan(p.getCode());
        }
        onExit();
    }


    @Override
    public void scan(String code) {
        if (code.isEmpty()) {
            invalidBarcode();
        } else {
            addProduct(code);
        }

    }

    private void addProduct(String code) {
        Product product = productDao.getByCode(code);
        if (product != null) {
            receipt.add(product);
            lcd.onProductDisplay(product);
        } else {
            lcd.onProductNotFoundDisplay();
        }
    }

    private void invalidBarcode() {
        lcd.onInvalidBarCodeDisplay();
    }

    public void onExit() {
        lcd.onTotalSumDisplay(receipt.getTotalSum().toString());
        printer.print(receipt.toString());
    }
}
