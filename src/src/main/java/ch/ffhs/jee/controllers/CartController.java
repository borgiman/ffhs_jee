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

    /**
     * add a product to the cart
     * @param productId id of the product to be added
     * @return redirect to the cart
     */
    public String addToCart(int productId) {
        this.productIds.add(productId);
        return "cart?faces-redirect=true";
    }

    /**
     * remove a product from the cart
     * @param productId id of the product to be removed
     * @return redirect to the cart
     */
    public String removeFromCart(int productId) {
        this.productIds.removeIf(x -> x.equals(productId));
        this.products.removeIf(x -> x.getId() == productId);
        return "cart?faces-redirect=true";
    }

    /**
     * returns the products in the cart
     */
    public ArrayList<Product> getProducts() {
        return this.products;
    }

    /**
     * returns the sum of all product prices in the cart
     * @return the sum of all product prices in the cart
     */
    public int getTotal() {
        return this.products.stream().mapToInt(Product::getPrice).sum();
    }

    /**
     * redirects to the cart
     * @return redirect to the cart
     */
    public String startOrdering() {
        return "order?faces-redirect=true";
    }

    /**
     * removes all products from the cart
     */
    public void clear() {
        this.productIds.clear();
        this.products.clear();
    }

    public void init() {
        this.products = productsRepository.getProducts(this.productIds);
    }
}
