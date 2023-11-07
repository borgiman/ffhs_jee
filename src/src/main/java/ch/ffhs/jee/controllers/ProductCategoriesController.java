package ch.ffhs.jee.controllers;

import ch.ffhs.jee.data.ProductCategoriesRepository;
import ch.ffhs.jee.models.ProductCategory;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.ArrayList;

@Named
@RequestScoped
public class ProductCategoriesController {
    private final ProductCategoriesRepository productCategoriesRepository;
    private ArrayList<ProductCategory> productCategories;

    @Inject
    public ProductCategoriesController(ProductCategoriesRepository productCategoriesRepository) {
        this.productCategoriesRepository = productCategoriesRepository;
    }

    // for whatever reason needed so cdi can proxy this class (weird design)
    protected ProductCategoriesController() {
        this(null);
    }

    /**
     * returns all product categories
     * @return all product categories
     */
    public ArrayList<ProductCategory> getProductCategories() {
        return this.productCategories;
    }

    @PostConstruct
    public void init() {
        this.productCategories = productCategoriesRepository.getProductCategories();
    }
}
