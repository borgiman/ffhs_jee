package ch.ffhs.jee.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductsControllerTest {
    private ProductsController productsController;

    @BeforeEach
    void setUp() {
        var testProductsRepository = new TestProductsRepository();
        this.productsController = new ProductsController(testProductsRepository);
    }

    @Test
    void getProductCategoryId() {
        this.productsController.setProductCategoryId(1);
        assertEquals(1, this.productsController.getProductCategoryId());
    }

    @Test
    void getProducts() {
        assertNull(this.productsController.getProducts());
        this.productsController.setProductCategoryId(1);
        this.productsController.init();
        assertEquals(3, this.productsController.getProducts().size());
        assertEquals(1, this.productsController.getProducts().get(0).getId());
        assertEquals(2, this.productsController.getProducts().get(1).getId());
        assertEquals(3, this.productsController.getProducts().get(2).getId());
    }
}