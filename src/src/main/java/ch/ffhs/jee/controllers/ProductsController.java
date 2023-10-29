package ch.ffhs.jee.controllers;

import ch.ffhs.jee.models.Product;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.util.ArrayList;

@Named
@RequestScoped
public class ProductsController {
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
        this.products = new ArrayList<>();

        for (var i = 0; i < 5; i++) {
            this.products.add(new Product(20767804, 95, "Philips", "TAT4556BK/00", "ANC, 29 h, Kabellos", 4, 51));
            this.products.add(new Product(21210362, 120, "Jabra", "Evolve 65 SE MS", "Kabelgebunden, Kabellos", 4, 49));
            this.products.add(new Product(16397391, 98, "Samsung", "Galaxy Buds2", "ANC, 5h, Kabellos", 4, 584));
            this.products.add(new Product(21993129, 232, "Apple", "AirPods Pro (2nd Gen.) MagSafe Case", "ANC, 6h, Kabellos", 5, 1516));
        }
    }
}
