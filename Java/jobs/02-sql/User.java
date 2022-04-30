package com.project;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class User {
	static HashMap<String, User> userMap = new HashMap<String, User>();

	// User DB bankuser table fields. the id is auto incremented
	static String userNameDB;
	static String userPasswordDB;
	static String firstNameDB;
	static String lastNameDB;
	static String userLevelDB;

	private final static String urlAWS = "jdbc:oracle:thin:@bankaccountdb.csylxpgfy4vi.us-east-1.rds.amazonaws.com:1521:orcl";
	private final static String usernameAWS = "jaenwawe";
	private final static String passwordAWS = "classTime";

	// callable statement
	public static void callableStatementExample(String userNameDB, String userPassword, String firstName,
			String lastName, String userLevel, Integer accountNo, Double userBalance) {
		try (Connection conn = DriverManager.getConnection(urlAWS, usernameAWS, passwordAWS)) {
			String sql = "{ call insert_BANKUSER_ID(?, ?, ?, ?, ?, ?, ?) }";

			CallableStatement cs = conn.prepareCall(sql);
			cs.setString(1, userNameDB);
			cs.setString(2, userPasswordDB);
			cs.setString(3, firstNameDB);
			cs.setString(4, lastNameDB);
			cs.setString(5, userLevelDB);
			cs.setInt(6, accountNo);
			cs.setDouble(7, userBalance);

			int status = cs.executeUpdate();
			System.out.println("Callable statement returns: " + status);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// prepared statement
	public static void preparedStatementExample(String userNameDB, String userPassword, String firstName,
			String lastName, String userLevel, Integer accountNo, Double userBalance) {
		try (Connection conn = DriverManager.getConnection(urlAWS, usernameAWS, passwordAWS)) {
			// prepared statement guards against sql injection
			// because it's pre-compiled (which also makes it faster)
			String sql = "INSERT INTO bankuser(USER_NAME, USER_PASSWORD, FIRST_NAME, LAST_NAME, USER_LEVEL, ACCOUNT_ID, BALANCE)VALUES(?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);

//			INSERT INTO bankuser(USER_NAME, USER_PASSWORD, FIRST_NAME, LAST_NAME, USER_LEVEL, ACCOUNT_ID, BALANCE) 
//			VALUES  ('jaenwawe', 'password', 'Jae', 'Nwawe', 'user', 11, 800);

//			CREATE Table bankuser(
//					USER_NAME              VARCHAR2(26) ,
//					USER_PASSWORD          VARCHAR2(26) ,
//					FIRST_NAME             VARCHAR2(25) ,
//					LAST_NAME              VARCHAR2(25) ,
//					USER_LEVEL             VARCHAR2(25), 
//					ACCOUNT_ID   NUMBER(15) ,
//					BALANCE             NUMBER(30) 
//					);
//			
			ps.setString(1, userNameDB);
			ps.setString(2, userPassword);
			ps.setString(3, firstName);
			ps.setString(4, lastName);
			ps.setString(5, userLevel);
			ps.setInt(6, accountNo);
			ps.setDouble(7, userBalance);
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void statementExample(String userNameDB, String userPasswordDB, String firstNameDB, String lastNameDB,
			String userLevelDB, Integer accountNo, Double userBalance) {
		try (Connection conn = DriverManager.getConnection(urlAWS, usernameAWS, passwordAWS)) {
			// does NOT guard against sql injection
			String sql = "INSERT INTO bankuser(userNameDB, String userPasswordDB, String firstNameDB,String lastNameDB, String userLevelDB, ACCOUNT_ID accountNo, String userLevelDB) "
					+ "VALUES('" + userNameDB + "', '" + userPasswordDB + "', '" + firstNameDB + "', '" + lastNameDB
					+ "', '" + userLevelDB + "', '" + accountNo + "', '" + userBalance + "' )";

			Statement statement = conn.createStatement();

			int numOfRowsChanged = statement.executeUpdate(sql);
			System.out.println("The # of rows changed: " + numOfRowsChanged);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// THIS IS AN EXAMPLE of how to query using JDBC
	public static List<User> selectAllPendingUsers() {
		// creating an array to hold the records from
		// the future query
		List<User> users = new ArrayList<>();

		try (Connection conn = DriverManager.getConnection(urlAWS, usernameAWS, passwordAWS)) {
			// query everything in the food table
			String sql = "SELECT * FROM bankuser";

			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			// This while loop is responsible for loading up the
			// arrayList we created with the values we pulled from
			// from the query.
			// "rs.next()" is a method used to access each record
			// inside of a result set
			while (rs.next()) {

//				USER_NAME           VARCHAR2(26) 
//				USER_PASSWORD       VARCHAR2(26) 
//				FIRST_NAME          VARCHAR2(25) 
//				LAST_NAME           VARCHAR2(25) 
//				USER_LEVEL          VARCHAR2(25) 
//				ACCOUNT_ID          NUMBER(15)   
//				BALANCE             NUMBER(30)   
//			
//				User currentUser = new User(String dbUserName, String dbPassword, String dbFirstName, String dbLastName, String dbUserLevel, Integer dbAccountNo, Double dbAccountBalance);
//				USER_NAME           VARCHAR2(26) 
//				USER_PASSWORD       VARCHAR2(26) 
//				FIRST_NAME          VARCHAR2(25) 
//				LAST_NAME           VARCHAR2(25) 
//				USER_LEVEL          VARCHAR2(25) 
//				ACCOUNT_ID          NUMBER(15)   
//				BALANCE             NUMBER(30)   
			//
				
//				String userNameDB, String userPasswordDB, String firstNameDB, String lastNameDB,
//				String userLevelDB, Integer accountNo, Double userBalance
//				
				User currentUser = new User(userNameDB,userPasswordDB, firstNameDB, lastNameDB,userLevelDB,accountNo, userBalance);

				
				users.add(currentUser);
				// we use "recipe" here instead of "rs.getString(3)"
				// in short, we use "recipe", aka the column name,
				// instead of getting the "3rd column" in the table
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	public static void addToUserMap(User user) {

		userMap.put(user.userlogIn, user);
	}

	static String clientUserName = "clientUserName"; // Employees can select User name to modify their account
	static String userlogIn = "setUserName";
	public String userLevel = "user";
	String password = "set";
	static Integer accountNo = 0000;
	int counter = 100; // goal make it increment

	String firstName = "FirstName";
	String lastName = "lastName";

	static Double userBalance = 0.0;

	Integer employeeID = 0000;

	static Scanner infoAccept = new Scanner(System.in);
	String response = "x";

	static String userSelection = "x";

	public static void mapToString(User currentUser) {
		System.out.println("\t mapToString(User currentUser) shows userMap entered " + currentUser.firstName + "\t "
				+ currentUser.lastName + "userName: " + User.userlogIn + " password: " + currentUser.password + " "
				+ "you are currently " + currentUser.userLevel + " with account " + currentUser.accountNo + " contains "
				+ User.userBalance + "\n");
	}

	public User(String userName, String password, String userLevel) {
		this.userlogIn = userName;
		this.password = password;
		this.firstName = "WinWin";
		this.lastName = "Worker";
		this.userLevel = userLevel;
		
	}

	public User(String dbUserName, String dbPassword, String dbFirstName, String dbLastName, String dbUserLevel,
			Integer dbAccountNo, Double dbAccountBalance) {
		this.userlogIn = dbUserName;
		this.password = dbPassword;
		this.firstName = dbFirstName;
		this.lastName = dbLastName;
		this.userLevel = dbUserLevel;
		this.accountNo = dbAccountNo;
		this.userBalance = dbAccountBalance;
	}

	public User(String logInUserName, String logInPassword, String userFirstName, String userLastName, String pendingUserLevel) {
		this.userlogIn = logInUserName;
		this.password = logInPassword;
		this.firstName = userFirstName;
		this.lastName = userLastName;
		this.userLevel = pendingUserLevel;
		counter++;
		this.accountNo = counter;
		this.userBalance = 0.00;
	}	


	public static String customerMenu() {
		String selection = "x";
		System.out.println("\tYour username and password match a current customers");

		System.out.println("Press:");
		System.out.println("w - to withdraw");
		System.out.println("d - to deposit");
		System.out.println("t - to transfer");
		System.out.println("x to Exit");
		selection = infoAccept.nextLine().trim();
		return selection;
	}

	public static String employeeMenu() {
		String selection = "x";
		System.out.println("Press:");
		System.out.println("w - to withdraw");
		System.out.println("d - to deposit");
		System.out.println("t - to transfer");
		System.out.println("v - to view all customer information");
		System.out.println("a - to deny or approve an account");
		System.out.println("x to Exit");
		selection = infoAccept.nextLine().trim();
		return selection;
	}

	public static String adminMenu() {
		String selection = "x";
		System.out.println("Press:");
		System.out.println("w - to withdraw");
		System.out.println("d - to deposit");
		System.out.println("t - to transfer");
		System.out.println("c - to cancel an account");
		System.out.println("v - to view all customer information");
		System.out.println("a - to deny or approve an account");
		System.out.println("x to Exit");
		selection = infoAccept.nextLine().trim();
		return selection;
	}

	public Double deposit(Double balance, Double transactionAmount) {
		balance = +transactionAmount;
		return balance;
	}

	public Double withdraw(Double balance, Double transactionAmount) {
		if (balance > transactionAmount)
			balance -= transactionAmount;
		else {
			System.out.println(
					"withdraw not completed because the transaction amount was greater than that available balance");
		}
		return balance;
	}

	public static void transferToFrom(User fromClient) {
		User transactionUser = userMap.get(fromClient.userlogIn);

		System.out.println("How much is the transaction?");
		String amount = infoAccept.nextLine().toLowerCase().trim();
		Double transaction = Double.parseDouble(amount);
		System.out.println("\t withdraw amount entered" + transaction);

		transactionUser.userBalance = transactionUser.withdraw(transactionUser.userBalance, transaction);
		userMap.put(transactionUser.userlogIn, transactionUser);
		mapToString(userMap.get(transactionUser.userlogIn));

		System.out.println("What user's account would you like to transfer to? Enter userName");
		String toClientUserID = infoAccept.nextLine().toLowerCase().trim();
		User toClient = userMap.get(toClientUserID);

		transactionUser = toClient;
		transactionUser.userBalance = transactionUser.deposit(transactionUser.userBalance, transaction);
		userMap.put(transactionUser.userlogIn, transactionUser);
		System.out.println("\t transaction amount entered" + transaction);
		mapToString(userMap.get(transactionUser.userlogIn));
	}

	public static User applyForAccount(String logInUserName, String logInPassword) {
		User registeredUser = new User(logInUserName, logInPassword, "pending");
		String selectionApply = "x";

		System.out.println("Type apply to open a bank account");
		selectionApply = infoAccept.nextLine().trim();
		System.out.println("Customer typed " + selectionApply + "for selectionApply");

		if (selectionApply.equalsIgnoreCase("apply")) {
			System.out.println("inside if and creating registered user bc Customer typed " + selectionApply
					+ "for selectionApply");
			registeredUser = new User(logInUserName, logInPassword, "pending");
			mapToString(registeredUser);
		}
		return registeredUser.userToCustomer(logInUserName, logInPassword);
	}

	public User userToCustomer(String logInUserName, String logInPassword) {
		System.out.println("What is your first name");
		String firstName = infoAccept.nextLine().trim();

		System.out.println("What is your last name");
		String lastName = infoAccept.nextLine().trim();

		Integer accountNo = counter++;
		String userLevel = "pending";
		User applicantUser = new User(logInUserName, logInPassword, firstName, lastName, userLevel);
		userMap.put(logInUserName, applicantUser);
		return applicantUser;
	}

	public static User getClientAccount(String clientUserName) {
		System.out.println("What user's account would you like? Enter userName");
		clientUserName = infoAccept.nextLine().toLowerCase().trim();
		return userMap.get(clientUserName);
	}

	public void menuOptions(String userSelection, User currentUser) {
		String amount;
		Double transaction;
		Double transactionBalance = 0.00;
		User transactionUser;

		switch (userSelection) {
		case "d":
			System.out.println("\tDebugging You made it to case d");
			if (currentUser.userLevel.equals("admin") || currentUser.userLevel.equals("employee")) {
				transactionUser = getClientAccount(clientUserName);
			} else {
				transactionUser = currentUser;
			}
			transactionBalance = transactionUser.userBalance;// store client's balance in buffer

			System.out.println("How much is the transaction?");
			amount = infoAccept.nextLine().toLowerCase().trim();
			transaction = Double.parseDouble(amount);

			transactionBalance = transactionBalance + transactionUser.deposit(transactionUser.userBalance, transaction);
			System.out.println("\t transaction amount entered" + transaction);

			mapToString(userMap.get(transactionUser.userlogIn));
			transactionUser.userBalance = transactionBalance;
			userMap.put(transactionUser.userlogIn, transactionUser);
			mapToString(transactionUser);
			break;

		case "w":
			System.out.println("\tDebugging You made it to case w");
			if (currentUser.userLevel.equals("admin") || currentUser.userLevel.equals("employee")) {
				transactionUser = getClientAccount(clientUserName);
			} else {
				transactionUser = currentUser;
			}

			System.out.println("How much is the transaction?");
			amount = infoAccept.nextLine().toLowerCase().trim();
			transaction = Double.parseDouble(amount);
			transactionUser.userBalance = transactionUser.withdraw(transactionUser.userBalance, transaction);
			userMap.put(transactionUser.userlogIn, transactionUser);
			mapToString(transactionUser);
			break;

		case "t":
			System.out.println("\tDebugging You made it to case t");
			User fromClient;

			if (currentUser.userLevel.equals("admin") || currentUser.userLevel.equals("employee")) {
				fromClient = getClientAccount(clientUserName);
				mapToString(userMap.get(fromClient.userlogIn));
			} else {
				fromClient = currentUser;
			}
			transferToFrom(fromClient);
			break;

		case "c":
			System.out.println("\tDebugging You made it to case c");

			System.out.println("\t Selected c");
			if (currentUser.userLevel.equals("admin"))

			{
				transactionUser = getClientAccount(currentUser.userlogIn);
			} else {
				transactionUser = currentUser;
			}
			transactionUser = userMap.get(transactionUser.userlogIn);
			transactionUser.userLevel = "cancelled";
			transactionUser.accountNo = 0000;
			transactionUser.userBalance = 000.00;
			transactionBalance = transactionUser.userBalance;// store

			userMap.put(transactionUser.userlogIn, transactionUser);

			mapToString(userMap.get(transactionUser.userlogIn));
			break;
		case "v":
			System.out.println("\tDebugging You made it to case v");
			if (userMap.get(currentUser.userlogIn).userLevel.equals("admin")) {
				for (String mapUserRecord : userMap.keySet()) {
					mapToString(userMap.get(mapUserRecord));
					System.out.println("\n");
				}
			} else
				System.exit(0);
			break;
		case "a":
			// Debugging
			// TODO
			System.out.println("\t Selected a");
			mapToString(currentUser);
			break;
		case "x":
			System.exit(0);
			System.out.println("DebbugginBreak point inside case x");
			break;

		default:
			System.exit(0);

		}

	}

	public static String getMenu(String userLevel) {
		switch (userLevel) {
		case "customer":
			userSelection = customerMenu();

			break;
		case "employee":

			userSelection = employeeMenu();
			break;
		case "admin":
			userSelection = adminMenu();
			break;
		default:
		}
		return userSelection;
	}

	public static void main(String[] args) {
		String welcomeUserPassword;
		String welcomeUserName;
		Boolean again = true;
		User currentUser = new User("adminteller", "admincode", "admin");

		System.out.println("Main - Enter a username");
		welcomeUserName = infoAccept.nextLine().trim();

		System.out.println("Main - Please enter a password");
		welcomeUserPassword = infoAccept.nextLine().trim();

		if (!userMap.containsKey(welcomeUserName))
			applyForAccount(welcomeUserName, welcomeUserPassword);
		else {
			do {
				if (userMap.containsKey(welcomeUserName)
						& welcomeUserPassword.matches((userMap.get(welcomeUserName)).password)) {
					currentUser = userMap.get(welcomeUserName);

					userSelection = getMenu(currentUser.userLevel);
					if (userSelection.equals("x")) {
						again = false;
						System.out.println("Exiting the software");
					}
					currentUser.menuOptions(userSelection, currentUser);
				}

			} while (again);
		}

		// statementExample("dressing", "grandmas love");

		currentUser = new User("teller", "code","employee");// userMap.put(currentUser.userName,
		// currentUser);

		userMap.put(currentUser.userlogIn, currentUser);
		mapToString(currentUser);

		userMap.put(currentUser.userlogIn, currentUser);
		currentUser = new User("customer", "password", "Barack", "Obama", "customer", 8080, 4040.0);
		userMap.put(currentUser.userlogIn, currentUser);
		mapToString(currentUser);

		for (User dbRecord : userMap.values()) {
			preparedStatementExample(userlogIn, dbRecord.password, dbRecord.firstName, dbRecord.lastName,
					dbRecord.userLevel, accountNo, userBalance);
		}

		mapToString(currentUser);

		// callableStatementExample("in N out", "cali");
//			System.out.println(selectAllFood());
		System.out.println("done");
	}

}
