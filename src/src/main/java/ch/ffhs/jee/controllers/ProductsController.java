package ch.ffhs.jee.controllers;

import ch.ffhs.jee.data.ProductsRepository;
import ch.ffhs.jee.models.Product;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.ArrayList;

@Named
@RequestScoped
public class ProductsController {
    private final ProductsRepository productsRepository;
    private int productCategoryId;
    private ArrayList<Product> products;

    @Inject
    public ProductsController(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    // for whatever reason needed so cdi can proxy this class (weird design)
    protected ProductsController() {
        this(null);
    }

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
