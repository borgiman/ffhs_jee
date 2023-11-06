package ch.ffhs.jee.controllers;

import ch.ffhs.jee.data.ProductCategoriesRepository;
import ch.ffhs.jee.data.ProductsRepository;
import ch.ffhs.jee.models.Product;
import ch.ffhs.jee.models.ProductCategory;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped
public class ProductController {
    private final ProductsRepository productsRepository;
    private final ProductCategoriesRepository productCategoriesRepository;
    private int productId;
    private Product product;
    private ProductCategory productCategory;

    @Inject
    public ProductController(ProductsRepository productsRepository, ProductCategoriesRepository productCategoriesRepository) {
        this.productsRepository = productsRepository;
        this.productCategoriesRepository = productCategoriesRepository;
    }

    // for whatever reason needed so cdi can proxy this class (weird design)
    protected ProductController() {
        this(null, null);
    }

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
