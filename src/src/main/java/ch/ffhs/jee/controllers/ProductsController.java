package ch.ffhs.jee.controllers;

import ch.ffhs.jee.data.ProductsRepository;
import ch.ffhs.jee.models.Product;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.util.ArrayList;

@Named
@RequestScoped
public class ProductsController {
    @EJB
    private ProductsRepository productsRepository;
    private int productCategoryId;
    private ArrayList<Product> products;

    public int getProductCategoryId() {
        return this.productCategoryId;
    }

    public void setProductCategoryId(int productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public ArrayList<Product> getProducts() {
        return this.products;
    }

    public void init() {
        this.products = productsRepository.getProductsByCategoryId(this.productCategoryId);
    }
}
