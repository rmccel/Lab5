package five;

import java.sql.*;

public class Delete {

	public static void main(String[] args) throws SQLException {
		final String DB_URL = "jdbc:hsqldb:file:ShoesDB/shoes";
		
		Connection conn = DriverManager.getConnection(DB_URL);
		
		Statement stmt = conn.createStatement();
		
		String sql = "DELETE FROM SHOES"
					 + " (Brand,Name,Price)"
					 + " VALUES "
					 + " ('Under Armour', 'Precision Mid', 109.99);";
		
		stmt.executeUpdate(sql);
		
		conn.close();
		
		System.out.println("Shoe(s) have been deleted!");
	}
}