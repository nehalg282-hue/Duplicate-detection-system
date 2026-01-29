import java.sql.;
import java.util.HashMap;

public class DuplicateChecker {

    private HashMap<Integer, String> map = new HashMap<>();
    private Connection connection;

    public DuplicateChecker(Connection connection) {
        this.connection = connection;
        loadDataFromDatabase();
    }

    // Load existing records into HashMap
    private void loadDataFromDatabase() {
        try {
            String query = "SELECT value, hash_value FROM records";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                map.put(rs.getInt("hash_value"), rs.getString("value"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Check if value already exists
    public boolean isDuplicate(String value) {
        int hash = value.hashCode();
        return map.containsKey(hash);
    }

    // Insert new record
    public void insertValue(String value) {
        try {
            int hash = value.hashCode();

            String query = "INSERT INTO records(value, hash_value) VALUES(?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, value);
            pstmt.setInt(2, hash);
            pstmt.executeUpdate();

            map.put(hash, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
