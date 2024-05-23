package net.javaweb.swp391_g6;

import io.github.cdimascio.dotenv.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication
public class Swp391G6Application {

	public static void main(String[] args) {
		SpringApplication.run(Swp391G6Application.class, args);
		Dotenv dotenv = Dotenv.load();

        String url = "jdbc:sqlserver://localhost:1433;databaseName=ExamDB";
        String username = "sa";
        String password = "123456";
        // Thiết lập các biến môi trường trong hệ thống
        System.setProperty("DB_USERNAME", dotenv.get("DB_USERNAME"));
        System.setProperty("DB_PASSWORD", dotenv.get("DB_PASSWORD"));

        // Khởi động ứng dụng Spring Boot
        SpringApplication.run(Swp391G6Application.class, args);
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            if (connection != null) {
                System.out.println("Kết nối thành công: true");
            } else {
                System.out.println("Kết nối không thành công: false");
            }
        } catch (SQLException e) {
            System.out.println("Kết nối không thành công: false");
            e.printStackTrace();
        }
	}

}
