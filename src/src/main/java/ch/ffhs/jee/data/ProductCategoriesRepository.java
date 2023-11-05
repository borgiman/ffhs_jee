package ch.ffhs.jee.data;

import ch.ffhs.jee.models.ProductCategory;
import jakarta.ejb.EJB;
import jakarta.ejb.Singleton;

import java.sql.ResultSet;
import java.util.ArrayList;

@Singleton
public class ProductCategoriesRepository {
    @EJB
    private DatabaseConnection databaseConnection;

    public ArrayList<ProductCategory> getProductCategories() {
        var productCategories = new ArrayList<ProductCategory>();

        try {
            var connection = databaseConnection.getConnection();
            var statement = connection.createStatement();
            var resultSet = statement.executeQuery("select id, name from categories");

            while (resultSet.next()) {
                var productCategory = mapFrom(resultSet);
                productCategories.add(productCategory);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return productCategories;
    }

    public ProductCategory getProductCategory(int productCategoryId) {
        ProductCategory productCategory = null;

        try {
            var connection = databaseConnection.getConnection();
            var statement = connection.prepareStatement("select id, name from categories where id = ?");
            statement.setInt(1, productCategoryId);
            var resultSet = statement.executeQuery();

            if (resultSet.next()) {
                productCategory = mapFrom(resultSet);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return productCategory;
    }

    private ProductCategory mapFrom(ResultSet resultSet) {
        try {
            var id = resultSet.getInt("id");
            var name = resultSet.getString("name");
            return new ProductCategory(id, name);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
