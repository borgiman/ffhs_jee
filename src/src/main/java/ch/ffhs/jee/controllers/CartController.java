package ch.ffhs.jee.controllers;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;

@Named
@SessionScoped
public class CartController implements Serializable {
    private final ArrayList<Integer> productIds;

    public CartController() {
        this.productIds = new ArrayList<>();
    }

    public void addToCart(int productId) {
        this.productIds.add(productId);
    }

    public ArrayList<Integer> getProductIds() {
        return this.productIds;
    }
}
