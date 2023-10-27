package ch.ffhs.jee.controllers;

import ch.ffhs.jee.models.ProductCategory;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.util.ArrayList;

@Named
@RequestScoped
public class ProductCategoriesController {
    public Iterable<ProductCategory> getProductCategories() {
        var productCategories = new ArrayList<ProductCategory>();

        try {
            var context = new InitialContext();
            var dataSource = (DataSource)context.lookup("jdbc/jee");
            var connection = dataSource.getConnection();
            var statement = connection.createStatement();
            var resultSet = statement.executeQuery("select id, name from categories");

            while (resultSet.next()) {
                var id = resultSet.getInt("id");
                var name = resultSet.getString("name");
                var productCategory = new ProductCategory(id, name);
                productCategories.add(productCategory);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return productCategories;
    }
}
