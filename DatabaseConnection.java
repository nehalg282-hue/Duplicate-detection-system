import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseConnection {

    public static Connection getConnection() {
        try {
            // Connect to SQLite database
            Connection connection = DriverManager.getConnection("jdbc:sqlite:records.db");

            // Create table if not exists
            Statement stmt = connection.createStatement();
            String query = "CREATE TABLE IF NOT EXISTS records (" + id INTEGER PRIMARY KEY AUTOINCREMENT," + "value TEXT," + "hash_value INTEGER)";
            stmt.execute(query);

            return connection;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
