package databaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import enums.operationTypeEnum;

public class DatabaseConnection {
	// Connection object
	// public static Connection con = null;
	// Statement object
	// public static Statement stmt;
	// Constant for Database URL
	// public static String DB_URL =
	// "jdbc:sqlserver://52.200.198.172\\MSSQLSERVER2017:54356;DatabaseName=pharmacy";
	// ;user=webapp;password=up1234$#@!
	// Constant for Database Username
	// public static String DB_USER = "webapp";
	// Constant for Database Password
	// public static String DB_PASSWORD = "up1234$#@!";

	private static String dbusername;
	private static String dbpassword;

	// Should be defined as jdbc:mysql://host:port/database name
	private static String databaseURLQA = "jdbc:sqlserver://52.200.198.172\\MSSQLSERVER2017:54356;DatabaseName=pharmacy";
	// private static String databaseURLSTAGE= "jdbc:mysql://stagehost:2020/easyDB";
	// private static String databaseURLPRODUCTION=
	// "jdbc:mysql://prodhost:2020/easyDB";

	public static String executeSQLQuery(String testEnv, String sqlQuery, operationTypeEnum operation) {
		String connectionUrl = "";
		Connection connection;
		String resultValue = "";
		ResultSet rs;
		int updatedRows;
		// To connect with QA Database
		if (testEnv.equalsIgnoreCase("QA")) {
			connectionUrl = databaseURLQA;
			dbusername = "webapp";
			dbpassword = "up1234$#@!";
		}
		// To connect with Stage Database
		// else if(testEnv.equalsIgnoreCase("STAGE")) {
		// connectionUrl = databaseURLSTAGE;
		// dbusername = "root";
		// dbpassword = "stagepassword";
		// }

		// To connect with Production Database
		// else if(testEnv.equalsIgnoreCase("PRODUCTION")) {
		// connectionUrl = databaseURLPRODUCTION;
		// dbusername = "root";
		// dbpassword = "prodpassword";
		// }
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			connection = DriverManager.getConnection(connectionUrl, dbusername, dbpassword);

			if (connection != null) {
				connection.setAutoCommit(false);

				System.out.println("Connected to the database...");
			} else {
				System.out.println("Database connection failed to " + testEnv + " Environment");
				return "no connection";
			}
			Statement stmt = connection.createStatement();
			if (operation == operationTypeEnum.Select) {
				System.out.println("Create statement");
				rs = stmt.executeQuery(sqlQuery);
				try {
					while (rs.next()) {
						resultValue = rs.getString(1).toString();
					}
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (NullPointerException err) {
					System.out.println("No Records obtained for this specific query");
					err.printStackTrace();
				}
			} else if (operation == operationTypeEnum.Update) {
				System.out.println("Update: In Progress");
				System.out.println("SQL Query:" + sqlQuery);

				updatedRows = stmt.executeUpdate(sqlQuery);
				// System.out.println("Number of commits: " + updatedRows);
				stmt.close();
				System.out.println("Update: Successful");
				connection.commit();
				System.out.println("Commit: Executed Successful");

			}

			connection.close();

		} catch (SQLException sqlEx) {
			System.out.println("SQL Exception:" + sqlEx.getStackTrace());
		}
		return resultValue;
	}

	public static ArrayList<String> executeSQLQuery_List(String testEnv, String sqlQuery) {
		String connectionUrl = "";
		Connection connection;
		ArrayList<String> resultValue = new ArrayList<String>();
		ResultSet resultSet;

		// To connect with QA Database
		if (testEnv.equalsIgnoreCase("QA")) {
			connectionUrl = databaseURLQA;
			dbusername = "webapp";
			dbpassword = "up1234$#@!";
		}

		// To connect with Stage Database
		// else if(testEnv.equalsIgnoreCase("STAGE")) {
		// connectionUrl = databaseURLSTAGE;
		// dbusername = "root";
		// dbpassword = "stagepassword";
		// }

		// To connect with Production Database
		// else if(testEnv.equalsIgnoreCase("PRODUCTION")) {
		// connectionUrl = databaseURLPRODUCTION;
		// dbusername = "root";
		// dbpassword = "prodpassword";
		// }

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			connection = DriverManager.getConnection(connectionUrl, dbusername, dbpassword);
			if (connection != null) {
				System.out.println("Connected to the database");
			} else {
				System.out.println("Failed to connect to " + testEnv + " database");
			}
			Statement statement = connection.createStatement();
			resultSet = statement.executeQuery(sqlQuery);

			try {
				while (resultSet.next()) {
					int columnCount = resultSet.getMetaData().getColumnCount();
					StringBuilder stringBuilder = new StringBuilder();
					for (int iCounter = 1; iCounter <= columnCount; iCounter++) {
						stringBuilder.append(resultSet.getString(iCounter).trim() + " ");
					}
					String reqValue = stringBuilder.substring(0, stringBuilder.length() - 1);
					resultValue.add(reqValue);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (NullPointerException ex) {
				System.out.println("No Records found for this specific query" + ex.getStackTrace());
			} finally {
				if (connection != null) {
					try {
						connection.close();
					} catch (SQLException ex) {
						System.out.println("SQL Exception:" + ex.getStackTrace());
					}
				}
			}

		} catch (SQLException sqlEx) {
			System.out.println("SQL Exception:" + sqlEx.getStackTrace());
		}
		return resultValue;
	}

}
