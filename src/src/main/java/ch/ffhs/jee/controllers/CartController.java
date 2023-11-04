package ch.ffhs.jee.controllers;

import ch.ffhs.jee.data.DatabaseConnection;
import ch.ffhs.jee.models.Product;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Named
@SessionScoped
public class CartController implements Serializable {
    @EJB
    private DatabaseConnection databaseConnection;
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

    public void init() {
        this.products = new ArrayList<>();

        try {
            var questionMarks = this.productIds.stream().map(x -> "?").collect(Collectors.joining(","));
            var connection = databaseConnection.getConnection();
            var statement = connection.prepareStatement("select id, categoryId, price, vendorName, productName, shortDetail, rating, numberOfRatings from products WHERE id in (" + questionMarks + ") order by id");

            for (var i = 0; i < this.productIds.size(); i++) {
                statement.setInt(i + 1, this.productIds.get(i));
            }

            var resultSet = statement.executeQuery();

            while (resultSet.next()) {
                var id = resultSet.getInt("id");

                if (!this.products.isEmpty() && this.products.get(this.products.size() - 1).getId() == id) {
                    continue;
                }

                var categoryId = resultSet.getInt("categoryId");
                var price = resultSet.getInt("price");
                var vendorName = resultSet.getString("vendorName");
                var productName = resultSet.getString("productName");
                var shortDetail = resultSet.getString("shortDetail");
                var rating = resultSet.getInt("rating");
                var numberOfRatings = resultSet.getInt("numberOfRatings");
                var product = new Product(id, categoryId, price, vendorName, productName, shortDetail, rating, numberOfRatings);
                this.products.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
