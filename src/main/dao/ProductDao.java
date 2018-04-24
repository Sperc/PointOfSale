package main.dao;

import main.model.Product;

public interface ProductDao {
    Product getByCode(String code);
}
