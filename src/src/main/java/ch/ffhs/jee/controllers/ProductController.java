package ch.ffhs.jee.controllers;

import ch.ffhs.jee.data.DatabaseConnection;
import ch.ffhs.jee.models.Product;
import ch.ffhs.jee.models.ProductCategory;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped
public class ProductController {
    @EJB
    private DatabaseConnection databaseConnection;
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
        try {
            var connection = databaseConnection.getConnection();
            var statement = connection.prepareStatement("select id, categoryId, price, vendorName, productName, shortDetail, rating, numberOfRatings from products WHERE id = ?");
            statement.setInt(1, this.getProductId());
            var resultSet = statement.executeQuery();

            if (resultSet.next()) {
                var id = resultSet.getInt("id");
                var categoryId = resultSet.getInt("categoryId");
                var price = resultSet.getInt("price");
                var vendorName = resultSet.getString("vendorName");
                var productName = resultSet.getString("productName");
                var shortDetail = resultSet.getString("shortDetail");
                var rating = resultSet.getInt("rating");
                var numberOfRatings = resultSet.getInt("numberOfRatings");
                this.product = new Product(id, categoryId, price, vendorName, productName, shortDetail, rating, numberOfRatings);

                statement = connection.prepareStatement("select id, name from categories where id = ?");
                statement.setInt(1, categoryId);
                resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    id = resultSet.getInt("id");
                    var name = resultSet.getString("name");
                    this.productCategory = new ProductCategory(id, name);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
