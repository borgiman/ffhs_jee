package ch.ffhs.jee.controllers;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped
public class OrderController {
    @Inject
    private CartController cartController;

    public String order(int productId) {
        this.cartController.addToCart(productId);
        return "cart?faces-redirect=true";
    }
}
