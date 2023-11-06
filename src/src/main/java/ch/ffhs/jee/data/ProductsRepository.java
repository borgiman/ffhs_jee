package ch.ffhs.jee.data;

import ch.ffhs.jee.models.Product;
import jakarta.ejb.Singleton;
import jakarta.inject.Inject;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Singleton
public class ProductsRepository {
    private final DatabaseConnection databaseConnection;

    @Inject
    public ProductsRepository(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    // for whatever reason needed so cdi can proxy this class (weird design)
    protected ProductsRepository() {
        this(null);
    }

    public ArrayList<Product> getProducts(ArrayList<Integer> productIds) {
        var products = new ArrayList<Product>();

        try {
            var questionMarks = productIds.stream().map(x -> "?").collect(Collectors.joining(","));
            var connection = databaseConnection.getConnection();
            var statement = connection.prepareStatement("select id, categoryId, price, vendorName, productName, shortDetail, rating, numberOfRatings from products WHERE id in (" + questionMarks + ") order by id");

            for (var i = 0; i < productIds.size(); i++) {
                statement.setInt(i + 1, productIds.get(i));
            }

            var resultSet = statement.executeQuery();

            while (resultSet.next()) {
                var product = mapFrom(resultSet);

                // filter out duplicate productIds with different categories, they are essentially the same product
                if (!products.isEmpty() && products.get(products.size() - 1).getId() == product.getId()) {
                    continue;
                }

                products.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return products;
    }

    public Product getProduct(int productId) {
        var productIds = new ArrayList<Integer>();
        productIds.add(productId);
        var products = getProducts(productIds);
        return !products.isEmpty() ? products.get(0) : null;
    }

    public ArrayList<Product> getProductsByCategoryId(int categoryId) {
        var products = new ArrayList<Product>();

        try {
            var connection = databaseConnection.getConnection();
            var statement = connection.prepareStatement("select id, categoryId, price, vendorName, productName, shortDetail, rating, numberOfRatings from products WHERE categoryId = ?");
            statement.setInt(1, categoryId);
            var resultSet = statement.executeQuery();

            while (resultSet.next()) {
                var product = mapFrom(resultSet);
                products.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return products;
    }

    private Product mapFrom(ResultSet resultSet) {
        try {
            var id = resultSet.getInt("id");
            var categoryId = resultSet.getInt("categoryId");
            var price = resultSet.getInt("price");
            var vendorName = resultSet.getString("vendorName");
            var productName = resultSet.getString("productName");
            var shortDetail = resultSet.getString("shortDetail");
            var rating = resultSet.getInt("rating");
            var numberOfRatings = resultSet.getInt("numberOfRatings");
            return new Product(id, categoryId, price, vendorName, productName, shortDetail, rating, numberOfRatings);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
