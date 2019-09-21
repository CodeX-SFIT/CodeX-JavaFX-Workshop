package codex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnect {
	static String URL = "jdbc:mysql://localhost:3306/secmpn";
	static Connection connection;

	public static void initDB() throws SQLException {
		connection = DriverManager.getConnection(
				URL,
				"root",
				""
		);
		System.out.println("Database connection initialized");
	}

	public static void closeDB() throws SQLException{
		connection.close();
		System.out.println("Connection closed");
	}

	public static Connection getConnection() {
		return connection;
	}
}
