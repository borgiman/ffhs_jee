package ch.ffhs.jee.controllers;

import ch.ffhs.jee.data.ProductsRepository;
import ch.ffhs.jee.models.Product;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;

@Named
@SessionScoped
public class CartController implements Serializable {
    @EJB
    private ProductsRepository productsRepository;
    private final ArrayList<Integer> productIds;
    private ArrayList<Product> products;

    public CartController() {
        this.productIds = new ArrayList<>();
        this.products = new ArrayList<>();
    }

    public String addToCart(int productId) {
        this.productIds.add(productId);
        return "cart?faces-redirect=true";
    }

    public String removeFromCart(int productId) {
        this.productIds.removeIf(x -> x.equals(productId));
        this.products.removeIf(x -> x.getId() == productId);
        return "cart?faces-redirect=true";
    }

    public ArrayList<Product> getProducts() {
        return this.products;
    }

    public int getTotal() {
        return this.products.stream().mapToInt(Product::getPrice).sum();
    }

    public String startOrdering() {
        return "order?faces-redirect=true";
    }

    public void clear() {
        this.productIds.clear();
        this.products.clear();
    }

    public void init() {
        this.products = productsRepository.getProducts(this.productIds);
    }
}
