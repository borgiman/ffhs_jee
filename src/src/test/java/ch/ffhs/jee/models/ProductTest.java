package ch.ffhs.jee.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    private Product product;

    @BeforeEach
    void setUp() {
        this.product = new Product(1, 2, 3, "vendorName", "productName", "shortDetail", 4, 5);
    }

    @Test
    void getId() {
        assertEquals(1, this.product.getId());
    }

    @Test
    void getCategoryId() {
        assertEquals(2, this.product.getCategoryId());
    }

    @Test
    void getPrice() {
        assertEquals(3, this.product.getPrice());
    }

    @Test
    void getVendorName() {
        assertEquals("vendorName", this.product.getVendorName());
    }

    @Test
    void getProductName() {
        assertEquals("productName", this.product.getProductName());
    }

    @Test
    void getShortDetail() {
        assertEquals("shortDetail", this.product.getShortDetail());
    }

    @Test
    void getRating() {
        assertEquals(4, this.product.getRating());
    }

    @Test
    void getNumberOfRatings() {
        assertEquals(5, this.product.getNumberOfRatings());
    }
}