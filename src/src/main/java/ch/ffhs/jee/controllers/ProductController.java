package ch.ffhs.jee.controllers;

import ch.ffhs.jee.data.ProductCategoriesRepository;
import ch.ffhs.jee.data.ProductsRepository;
import ch.ffhs.jee.models.Product;
import ch.ffhs.jee.models.ProductCategory;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class ProductController {
    @EJB
    private ProductsRepository productsRepository;
    @EJB
    private ProductCategoriesRepository productCategoriesRepository;
    private int productId;
    private Product product;
    private ProductCategory productCategory;

    public int getProductId() {
        return this.productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public Product getProduct() {
        return this.product;
    }

    public ProductCategory getProductCategory() {
        return this.productCategory;
    }

    public void init() {
        this.product = productsRepository.getProduct(this.productId);
        this.productCategory = productCategoriesRepository.getProductCategory(this.product.getCategoryId());
    }
}
