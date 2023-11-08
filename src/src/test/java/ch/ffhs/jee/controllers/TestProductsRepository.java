package ch.ffhs.jee.controllers;

import ch.ffhs.jee.data.ProductsRepository;
import ch.ffhs.jee.models.Product;

import java.util.ArrayList;

public class TestProductsRepository extends ProductsRepository {
    @Override
    public ArrayList<Product> getProducts(ArrayList<Integer> productIds) {
        var products = new ArrayList<Product>();

        for (var productId : productIds) {
            products.add(getProduct(productId));
        }

        return products;
    }

    @Override
    public Product getProduct(int productId) {
        return new Product(productId, productId, productId, String.valueOf(productId), String.valueOf(productId), String.valueOf(productId), productId, productId);
    }

    @Override
    public ArrayList<Product> getProductsByCategoryId(int categoryId) {
        var products = new ArrayList<Product>();
        products.add(new Product(1, categoryId, 1, "1", "1", "1", 1, 1));
        products.add(new Product(2, categoryId, 2, "2", "2", "2", 2, 2));
        products.add(new Product(3, categoryId, 3, "3", "3", "3", 3, 3));
        return products;
    }
}
