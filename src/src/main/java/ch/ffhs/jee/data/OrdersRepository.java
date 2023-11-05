package ch.ffhs.jee.data;

import ch.ffhs.jee.models.Product;
import jakarta.ejb.EJB;
import jakarta.ejb.Singleton;

import java.sql.Statement;
import java.util.ArrayList;

@Singleton
public class OrdersRepository {
    @EJB
    private DatabaseConnection databaseConnection;

    public void addOrder(String firstname, String lastname, String streetAndHouseNr, int plz, String city, String email, ArrayList<Product> products) {
        try {
            var connection = databaseConnection.getConnection();
            var statement = connection.prepareStatement("insert into orders (firstname, lastname, streetAndHouseNr, plz, city, email) VALUES (?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, firstname);
            statement.setString(2, lastname);
            statement.setString(3, streetAndHouseNr);
            statement.setInt(4, plz);
            statement.setString(5, city);
            statement.setString(6, email);
            statement.executeUpdate();
            var insertedIds = statement.getGeneratedKeys();
            insertedIds.next();
            var orderId = insertedIds.getInt(1);

            for (var i = 0; i < products.size(); i++) {
                var product = products.get(i);
                statement = connection.prepareStatement("insert into orderentries (orderId, productId, categoryId, price) VALUES (?, ?, ?, ?)");
                statement.setInt(1, orderId);
                statement.setInt(2, product.getId());
                statement.setInt(3, product.getCategoryId());
                statement.setInt(4, product.getPrice());
                statement.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
