package net.javaweb.swp391_g6;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

public class DatabaseConnectionTest  {

    @Test
    public static void testDatabaseConnection() {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=ExamDB";
        String username = "sa";
        String password = "123456";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            assertTrue(connection.isValid(5)); // Kiểm tra xem kết nối có hợp lệ không
            System.out.println("Connected to the database.");
        } catch (SQLException e) {
            fail("connected fail " + e.getMessage());
        }
    }
}
