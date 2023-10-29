package ch.ffhs.jee.controllers;

import ch.ffhs.jee.data.DatabaseConnection;
import ch.ffhs.jee.models.ProductCategory;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.util.ArrayList;

@Named
@RequestScoped
public class ProductCategoriesController {
    @EJB
    private DatabaseConnection databaseConnection;
    private ArrayList<ProductCategory> productCategories;

    public ArrayList<ProductCategory> getProductCategories() {
        return this.productCategories;
    }

    @PostConstruct
    public void init() {
        this.productCategories = new ArrayList<>();

        try {
            var connection = databaseConnection.getConnection();
            var statement = connection.createStatement();
            var resultSet = statement.executeQuery("select id, name from categories");

            while (resultSet.next()) {
                var id = resultSet.getInt("id");
                var name = resultSet.getString("name");
                var productCategory = new ProductCategory(id, name);
                this.productCategories.add(productCategory);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
