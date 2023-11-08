package ch.ffhs.jee.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductCategoriesControllerTest {
    private ProductCategoriesController productCategoriesController;

    @BeforeEach
    void setUp() {
        var testProductCategoriesRepository = new TestProductCategoriesRepository();
        this.productCategoriesController = new ProductCategoriesController(testProductCategoriesRepository);
    }

    @Test
    void getProductCategories() {
        this.productCategoriesController.init();
        assertEquals(3, this.productCategoriesController.getProductCategories().size());
        assertEquals(1, this.productCategoriesController.getProductCategories().get(0).getId());
        assertEquals(2, this.productCategoriesController.getProductCategories().get(1).getId());
        assertEquals(3, this.productCategoriesController.getProductCategories().get(2).getId());
    }
}