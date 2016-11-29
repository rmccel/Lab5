package five;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UserInsert {

	public static void main(String[] args) throws SQLException{
		
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Give me a brand:");
		String brand = keyboard.nextLine();
		System.out.println("Give me the product name:");
		String name = keyboard.nextLine();
		System.out.println("Give me the price:");
		String price = keyboard.nextLine();
		
		final String DB_URL = "jdbc:hsqldb:file:ShoesDB/shoes";
		
		Connection conn = DriverManager.getConnection(DB_URL);
		
	
		String sql = "INSERT INTO SHOES"
					 + " (Brand,Name,Price)"
					 + " VALUES "
					 + " (?, ?, ?);";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		stmt.setString(1, brand);
		stmt.setString(2, name);
		stmt.setDouble(3, Double.parseDouble(price));
		
		stmt.executeUpdate();
		
		conn.close();
		
		System.out.println("Shoes have been inserted!");
	}

}
