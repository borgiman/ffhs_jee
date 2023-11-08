package ch.ffhs.jee.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CartControllerTest {
    private CartController cartController;

    @BeforeEach
    void setUp() {
        var testsProductsRepository = new TestProductsRepository();
        this.cartController = new CartController(testsProductsRepository);
    }

    @Test
    void addToCart() {
        assertEquals(0, this.cartController.getProducts().size());
        this.cartController.addToCart(1);
        this.cartController.init();
        assertEquals(1, this.cartController.getProducts().size());
        assertEquals(1, this.cartController.getProducts().get(0).getId());
    }

    @Test
    void removeFromCart() {
        assertEquals(0, this.cartController.getProducts().size());
        this.cartController.addToCart(1);
        this.cartController.init();
        this.cartController.removeFromCart(1);
        this.cartController.init();
        assertEquals(0, this.cartController.getProducts().size());
    }

    @Test
    void getTotal() {
        this.cartController.addToCart(1);
        this.cartController.addToCart(2);
        this.cartController.init();
        assertEquals(3, this.cartController.getTotal());
    }

    @Test
    void startOrdering() {
        assertEquals("order?faces-redirect=true", this.cartController.startOrdering());
    }

    @Test
    void clear() {
        this.cartController.addToCart(1);
        this.cartController.addToCart(2);
        this.cartController.init();
        this.cartController.clear();
        assertEquals(0, this.cartController.getProducts().size());
    }
}