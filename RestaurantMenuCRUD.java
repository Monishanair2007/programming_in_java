import java.sql.*;

public class RestaurantMenuCRUD {
    public static void main(String[] args) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            Statement stmt = conn.createStatement();

            // Create Restaurant table if not exists
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS Restaurant (" +
                    "Id INT PRIMARY KEY AUTO_INCREMENT, " +
                    "Name VARCHAR(100), " +
                    "Address VARCHAR(200))");

            // Create MenuItem table if not exists
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS MenuItem (" +
                    "Id INT PRIMARY KEY AUTO_INCREMENT, " +
                    "Name VARCHAR(100), " +
                    "Price INT, " +
                    "ResId INT, " +
                    "FOREIGN KEY (ResId) REFERENCES Restaurant(Id))");

            // Clear old data
            stmt.executeUpdate("DELETE FROM MenuItem");
            stmt.executeUpdate("DELETE FROM Restaurant");

            // Insert Restaurants
            for (int i = 1; i <= 10; i++) {
                stmt.executeUpdate(
                        "INSERT INTO Restaurant (Name, Address) VALUES ('Restaurant" + i + "', 'Address" + i + "')");
            }
            stmt.executeUpdate("INSERT INTO Restaurant (Name, Address) VALUES ('Cafe Java', 'Main Street')");

            // Insert MenuItems
            for (int i = 1; i <= 10; i++) {
                stmt.executeUpdate("INSERT INTO MenuItem (Name, Price, ResId) VALUES ('Item" + i + "', " + (i * 50)
                        + ", " + i + ")");
            }
            stmt.executeUpdate(
                    "INSERT INTO MenuItem (Name, Price, ResId) VALUES ('Pasta Special', 80, (SELECT Id FROM Restaurant WHERE Name='Cafe Java'))");

            // Select MenuItems where price <= 100
            System.out.println("MenuItems with price <= 100:");
            ResultSet rs1 = stmt.executeQuery("SELECT * FROM MenuItem WHERE Price <= 100");
            ResultSetPrinter.print(rs1);

            // Select MenuItems from Cafe Java
            System.out.println("MenuItems from Cafe Java:");
            ResultSet rs2 = stmt.executeQuery(
                    "SELECT m.* FROM MenuItem m JOIN Restaurant r ON m.ResId = r.Id WHERE r.Name = 'Cafe Java'");
            ResultSetPrinter.print(rs2);

            // Update MenuItems where price <= 100 → set price = 200
            stmt.executeUpdate("UPDATE MenuItem SET Price = 200 WHERE Price <= 100");
            System.out.println("MenuItems after updating price <= 100 to 200:");
            ResultSet rs3 = stmt.executeQuery("SELECT * FROM MenuItem");
            ResultSetPrinter.print(rs3);

            // Delete MenuItems where name starts with 'P'
            stmt.executeUpdate("DELETE FROM MenuItem WHERE Name LIKE 'P%'");
            System.out.println("MenuItems after deleting names starting with 'P':");
            ResultSet rs4 = stmt.executeQuery("SELECT * FROM MenuItem");
            ResultSetPrinter.print(rs4);

        } catch (SQLSyntaxErrorException e) {
            System.out.println("SQL syntax error: " + e.getMessage());
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Constraint violation (e.g., foreign key or duplicate key): " + e.getMessage());
        } catch (SQLNonTransientConnectionException e) {
            System.out.println("Database connection error: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("General SQL exception: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }
}
