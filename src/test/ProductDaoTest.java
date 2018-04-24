package test;

import main.dao.ProductDao;
import main.dao.implementation.ProductDaoImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ProductDaoTest {
    private ProductDao productDao;
    private final String CORRECT_CODE = "123451";
    private final String INCORRECT_CODE = "333";

    @Before
    public void setUp() {
        productDao = new ProductDaoImpl();
    }

    @Test
    public void getProductCorrect() {
        Assert.assertNotEquals(null, productDao.getByCode(CORRECT_CODE));
    }

    @Test
    public void getProductIncorrect() {
        Assert.assertEquals(productDao.getByCode(INCORRECT_CODE), null);
    }
}
