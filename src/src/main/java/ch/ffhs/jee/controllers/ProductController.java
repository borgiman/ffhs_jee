package ch.ffhs.jee.controllers;

import ch.ffhs.jee.data.DatabaseConnection;
import ch.ffhs.jee.models.Product;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class ProductController {
    @EJB
    private DatabaseConnection databaseConnection;
    private int productId;
    private Product product;

    public int getProductId() {
        return this.productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public Product getProduct() {
        return this.product;
    }

    public void init() {
        try {
            var connection = databaseConnection.getConnection();
            var statement = connection.prepareStatement("select id, price, vendorName, productName, shortDetail, rating, numberOfRatings from products WHERE id = ?");
            statement.setInt(1, this.getProductId());
            var resultSet = statement.executeQuery();

            while (resultSet.next()) {
                var id = resultSet.getInt("id");
                var price = resultSet.getInt("price");
                var vendorName = resultSet.getString("vendorName");
                var productName = resultSet.getString("productName");
                var shortDetail = resultSet.getString("shortDetail");
                var rating = resultSet.getInt("rating");
                var numberOfRatings = resultSet.getInt("numberOfRatings");
                this.product = new Product(id, price, vendorName, productName, shortDetail, rating, numberOfRatings);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
