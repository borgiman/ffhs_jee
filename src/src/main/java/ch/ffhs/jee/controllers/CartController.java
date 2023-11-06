package ch.ffhs.jee.controllers;

import ch.ffhs.jee.data.ProductsRepository;
import ch.ffhs.jee.models.Product;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;

@Named
@SessionScoped
public class CartController implements Serializable {
    private final ProductsRepository productsRepository;
    private final ArrayList<Integer> productIds;
    private ArrayList<Product> products;

    @Inject
    public CartController(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
        this.productIds = new ArrayList<>();
        this.products = new ArrayList<>();
    }

    // for whatever reason needed so cdi can proxy this class (weird design)
    protected CartController() {
        this(null);
    }

    // todo add test
    public String addToCart(int productId) {
        this.productIds.add(productId);
        return "cart?faces-redirect=true";
    }

    // todo add test
    public String removeFromCart(int productId) {
        this.productIds.removeIf(x -> x.equals(productId));
        this.products.removeIf(x -> x.getId() == productId);
        return "cart?faces-redirect=true";
    }

    // todo add test
    public ArrayList<Product> getProducts() {
        return this.products;
    }

    // todo add test
    public int getTotal() {
        return this.products.stream().mapToInt(Product::getPrice).sum();
    }

    // todo add test
    public String startOrdering() {
        return "order?faces-redirect=true";
    }

    // todo add test
    public void clear() {
        this.productIds.clear();
        this.products.clear();
    }

    public void init() {
        this.products = productsRepository.getProducts(this.productIds);
    }
}
