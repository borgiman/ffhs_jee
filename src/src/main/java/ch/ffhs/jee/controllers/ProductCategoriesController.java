package ch.ffhs.jee.controllers;

import ch.ffhs.jee.data.ProductCategoriesRepository;
import ch.ffhs.jee.models.ProductCategory;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.util.ArrayList;

@Named
@RequestScoped
public class ProductCategoriesController {
    @EJB
    private ProductCategoriesRepository productCategoriesRepository;
    private ArrayList<ProductCategory> productCategories;

    public ArrayList<ProductCategory> getProductCategories() {
        return this.productCategories;
    }

    @PostConstruct
    public void init() {
        this.productCategories = productCategoriesRepository.getProductCategories();
    }
}
