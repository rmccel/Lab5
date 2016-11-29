package five;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App 
{
    public static void main( String[] args ) throws SQLException
    {
    	final String DB_URL = "jdbc:hsqldb:file:ShoesDB/shoes";
    	
    	String sqlStatement = "SELECT * FROM SHOES ORDER BY DESCRIPTION";
    	
    	Connection conn = DriverManager.getConnection(DB_URL);
    	
    	Statement stmt = conn.createStatement();
    	
    	ResultSet result = stmt.executeQuery(sqlStatement);
    	
    	while(result.next()){
    		System.out.println(result.getString("brand") + " " + result.getDouble("price"));
    	}
    	conn.close();
    }
}