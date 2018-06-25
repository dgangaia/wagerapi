package org.com.au.wagerapi.utilites;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.com.au.wagerapi.service.BetTypeService;

public class DBConnection {

	public static Logger LOG = Logger.getLogger(DBConnection.class);
	
	private static final String DATABASE_DRIVER = "org.postgresql.Driver";
	private static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/wagerdb";
	private static final String USERNAME = "admin_user";
	private static final String PASSWORD = "admin";

	private Connection connection;
	private Properties properties;

	private Properties getProperties() {
		if (properties == null) {
			properties = new Properties();
			properties.setProperty("user", USERNAME);
			properties.setProperty("password", PASSWORD);
		}
		return properties;
	}

	public Connection connect() {
		if (connection == null) {
			try {
				Class.forName(DATABASE_DRIVER);
				connection = DriverManager.getConnection(DATABASE_URL, getProperties());
				LOG.info("Postgre:LocalHost : Connection Established");
			} catch (ClassNotFoundException | SQLException e) {
				LOG.error("Postgre:LocalHost : Exception"+e.getMessage());
				e.printStackTrace();
			}
		}
		return connection;
	}

	public void disconnect() {
		if (connection != null) {
			try {
				connection.close();
				connection = null;
				LOG.info("Postgre:LocalUser : Connection Closed Succesfully");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
