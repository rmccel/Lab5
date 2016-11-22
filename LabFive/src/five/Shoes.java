package five;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

	//Must contain at least: Brand, Name, Type, Size, Price

	//Pre-populate with at least 5 shoes during create.

	//Write a program that allows a user to insert new shoes and/or delete existing shoes.

	//Write a program that allows a user to list all shoes filtered by the user input minimum
		//size and maximum size. Display the sum of the prices for the shoes filtered by the user.


public class Shoes {

	public static void main(String[] args) {
		final String DB_URL = "jdbc:hsqldb:file:ShoesDB/shoes";	//create database
		
		try {
			Connection conn = DriverManager.getConnection(DB_URL);	//connect to database

			dropShoesTables(conn);	//if DB exists, remove table

			buildShoesTables(conn);	//build shoes DB

			conn.close();	//close
			
		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
		}
	}
	
	public static void dropShoesTables (Connection conn){
			System.out.println("Checking for existing tables.");

			try {
				Statement stmt = conn.createStatement();	//get statement
				;

				try {
					stmt.execute("DROP TABLE Shoes");		//drops shoes
					System.out.println("Shoes table dropped.");
				} catch (SQLException ex) {
				}
			} catch (SQLException ex) {
				System.out.println("ERROR: " + ex.getMessage());
				ex.printStackTrace();
			}
		}
	
	public static void buildShoesTables (Connection conn) {
		try{
			Statement stmt = conn.createStatement();
			
			stmt.execute("CREATE TABLE Shoes (" + "Brand CHAR(30) , " + "Name CHAR(30) , " + "Type CHAR(30), "
						+ "Size DOUBLE," + "Price DOUBLE " + ")");
			
			stmt.execute("INSERT INTO Shoes VALUES ( " + "'Steve Madden', " + "'Veronica', " + "'Boot', " + "7.5, "
						+ "105.99 )");		//insert shoe #1
			
			stmt.execute("INSERT INTO Shoes VALUES ( " + "'Toms', " + "'Alessandra', " + "'Flat', " + "7, "
					+ "49.99 )");		//insert shoe #2
			
			stmt.execute("INSERT INTO Shoes VALUES ( " + "'Steve Madden', " + "'Veronica', " + "'Boot', " + "7.5, "
					+ "105.99 )");		//insert shoe #3
			
			stmt.execute("INSERT INTO Shoes VALUES ( " + "'Steve Madden', " + "'Veronica', " + "'Boot', " + "7.5, "
					+ "105.99 )");		//insert shoe #4
			
			stmt.execute("INSERT INTO Shoes VALUES ( " + "'Steve Madden', " + "'Veronica', " + "'Boot', " + "7.5, "
					+ "105.99 )");		//insert shoe #5
			
			System.out.println("Your shoes table has been created.");
		} catch (SQLException ex) {
			System.out.println("ERROR: " + ex.getMessage());
		}
		}
	}

