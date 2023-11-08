package ch.ffhs.jee.controllers;

import ch.ffhs.jee.data.ProductCategoriesRepository;
import ch.ffhs.jee.models.ProductCategory;

import java.util.ArrayList;

public class TestProductCategoriesRepository extends ProductCategoriesRepository {
    @Override
    public ArrayList<ProductCategory> getProductCategories() {
        var productCategories = new ArrayList<ProductCategory>();
        productCategories.add(this.getProductCategory(1));
        productCategories.add(this.getProductCategory(2));
        productCategories.add(this.getProductCategory(3));
        return productCategories;
    }

    @Override
    public ProductCategory getProductCategory(int productCategoryId) {
        return new ProductCategory(productCategoryId, String.valueOf(productCategoryId));
    }
}
