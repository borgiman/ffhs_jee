package ch.ffhs.jee.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductControllerTest {
    private ProductController productController;

    @BeforeEach
    void setUp() {
        var testProductsRepository = new TestProductsRepository();
        var testProductCategoriesRepository = new TestProductCategoriesRepository();
        this.productController = new ProductController(testProductsRepository, testProductCategoriesRepository);
    }

    @Test
    void getProductId() {
        this.productController.setProductId(1);
        assertEquals(1, this.productController.getProductId());
    }

    @Test
    void getProduct() {
        assertNull(this.productController.getProduct());
        this.productController.setProductId(1);
        this.productController.init();
        assertEquals(1, this.productController.getProduct().getId());
    }

    @Test
    void getProductCategory() {
        assertNull(this.productController.getProductCategory());
        this.productController.setProductId(1);
        this.productController.init();
        assertEquals(1, this.productController.getProductCategory().getId());
    }
}