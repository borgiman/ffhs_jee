package ch.ffhs.jee.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductCategoryTest {
    private ProductCategory productCategory;

    @BeforeEach
    void setUp() {
        this.productCategory = new ProductCategory(1, "name");
    }

    @Test
    void getId() {
        assertEquals(1, this.productCategory.getId());
    }

    @Test
    void getName() {
        assertEquals("name", this.productCategory.getName());
    }
}