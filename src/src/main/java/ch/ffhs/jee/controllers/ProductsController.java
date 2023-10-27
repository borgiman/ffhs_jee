package ch.ffhs.jee.controllers;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class ProductsController {
    private int productCategoryId;

    public int getProductCategoryId() {
        return this.productCategoryId;
    }

    public void setProductCategoryId(int productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public void init() {

    }
}
