package ch.ffhs.jee.controllers;

import ch.ffhs.jee.data.DatabaseConnection;
import ch.ffhs.jee.models.Product;
import ch.ffhs.jee.models.ProductCategory;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.util.ArrayList;

@Named
@RequestScoped
public class ProductsController {
    @EJB
    private DatabaseConnection databaseConnection;
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

        try {
            var connection = databaseConnection.getConnection();
            var statement = connection.prepareStatement("select id, price, vendorName, productName, shortDetail, rating, numberOfRatings from products WHERE categoryId = ?");
            statement.setInt(1, this.getProductCategoryId());
            var resultSet = statement.executeQuery();

            while (resultSet.next()) {
                var id = resultSet.getInt("id");
                var price = resultSet.getInt("price");
                var vendorName = resultSet.getString("vendorName");
                var productName = resultSet.getString("productName");
                var shortDetail = resultSet.getString("shortDetail");
                var rating = resultSet.getInt("rating");
                var numberOfRatings = resultSet.getInt("numberOfRatings");
                var product = new Product(id, price, vendorName, productName, shortDetail, rating, numberOfRatings);
                this.products.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
