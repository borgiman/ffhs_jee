package ch.ffhs.jee.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderControllerTest {
    private OrderController orderController;

    @BeforeEach()
    void setUp() {
        var testOrdersRepository = new TestOrdersRepository();
        var testsProductsRepository = new TestProductsRepository();
        var cartController = new CartController(testsProductsRepository);
        this.orderController = new OrderController(testOrdersRepository, cartController);
    }

    @Test
    void getFirstname() {
        this.orderController.setFirstname("firstname");
        assertEquals("firstname", this.orderController.getFirstname());
    }

    @Test
    void getLastname() {
        this.orderController.setLastname("lastname");
        assertEquals("lastname", this.orderController.getLastname());
    }

    @Test
    void getStreetAndHouseNr() {
        this.orderController.setStreetAndHouseNr("streetAndHouseNr");
        assertEquals("streetAndHouseNr", this.orderController.getStreetAndHouseNr());
    }

    @Test
    void getPlz() {
        this.orderController.setPlz(1234);
        assertEquals(1234, this.orderController.getPlz());
    }

    @Test
    void getCity() {
        this.orderController.setCity("city");
        assertEquals("city", this.orderController.getCity());
    }

    @Test
    void getEmail() {
        this.orderController.setEmail("email");
        assertEquals("email", this.orderController.getEmail());
    }

    @Test
    void order() {
        assertEquals("thanks?faces-redirect=true", this.orderController.order());
    }
}