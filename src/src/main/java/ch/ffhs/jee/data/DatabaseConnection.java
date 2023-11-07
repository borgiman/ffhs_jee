package ch.ffhs.jee.data;

import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Startup
@Singleton
public class DatabaseConnection {
    private final Connection connection;

    /**
     * initiates the database connection
     */
    public DatabaseConnection() throws SQLException, NamingException {
        var context = new InitialContext();
        var dataSource = (DataSource)context.lookup("jdbc/jee");
        this.connection = dataSource.getConnection();
    }

    public Connection getConnection() {
        return this.connection;
    }
}
