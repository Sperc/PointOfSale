package main.dao.implementation;

import main.dao.ProductDao;
import main.db.Database;
import main.model.Product;

public class ProductDaoImpl implements ProductDao {

    Database database = new Database();
    @Override
    public Product getByCode(String code) {
        return database.gerProductByName(code);
    }
}
