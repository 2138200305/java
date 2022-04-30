package com.example;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Food;

public class MainDriver {

	/*For ORACLE DBMS specifically the pattern is:
	 *     "jdbc:oracle:thin:@[endpoint]:[port]:[database-name]"
	 * 
	 * private static String url= "jdbc:oracle:thin:@localhost:1521:xe";
	 */
	private static String url = "jdbc:oracle:thin:@revychan.c4wt8faaxlgp.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "pokemondb";
	private static String password = "p4ssw0rd";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 //statementExample("dressing", "grandmas love");
		//preparedStatementExample("pizza", "stuffed crust");
		// callableStatementExample("in N out", "cali");
		System.out.println(selectAllFood());
		System.out.println("done");
	}

	// callable statement
	public static void callableStatementExample(String f_name, String f_recipe) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "{ call insert_food_null_id(?,?) }";

			CallableStatement cs = conn.prepareCall(sql);
			cs.setString(1, f_name);
			cs.setString(2, f_recipe);

			int status = cs.executeUpdate();
			System.out.println("Callable statement returns: " + status);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// prepared statement
	public static void preparedStatementExample(String f_name, String f_recipe) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			// prepared statement guards against sql injection
			// because it's pre-compiled (which also makes it faster)
			String sql = "INSERT INTO food(food_name, recipe) VALUES(?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, f_name);
			ps.setString(2, f_recipe);
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// statements
	public static void statementExample(String f_name, String f_recipe) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			// does NOT guard against sql injection
			String sql = "INSERT INTO food(food_name, recipe) " + "VALUES('" + f_name + "', '" + f_recipe + "' )";
				/*TALKING ABOUT SQL INJECTION
				 * "Insert into ('"+userEnteredValue"');";
				userEnteredVAlue=";DROP TABLE FOOD;";
				
				"Insert into (';DROP TABLE FOOD;');";*/
			Statement statement = conn.createStatement();

			int numOfRowsChanged = statement.executeUpdate(sql);
			System.out.println("The # of rows changed: " + numOfRowsChanged);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// THIS IS AN EXAMPLE of how to query using JDBC
	public static List<Food> selectAllFood() {
		// creating an array to hold the records from
		// the future query
		List<Food> foods = new ArrayList<>();

		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			// query everything in the food table
			String sql = "SELECT * FROM food";

			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			// This while loop is responsible for loading up the
			// arrayList we created with the values we pulled from
			// from the query.
			// "rs.next()" is a method used to access each record
			// inside of a result set
			while (rs.next()) {
				foods.add(new Food(rs.getInt(1), rs.getString(2), rs.getString("recipe")));
				// we use "recipe" here instead of "rs.getString(3)"
				// in short, we use "recipe", aka the column name,
				// instead of getting the "3rd column" in the table
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return foods;
	}

}
