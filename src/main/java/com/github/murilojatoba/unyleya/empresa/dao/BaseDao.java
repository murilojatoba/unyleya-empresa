package com.github.murilojatoba.unyleya.empresa.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BaseDao {

	BaseDao() {
		try {
			Class.forName("org.postgresql.Driver");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	protected Connection getConnection() throws SQLException {
		String url = "jdbc:postgresql://localhost:5432/unyleya";
		Connection conn = DriverManager.getConnection(url, "postgres", "123456");

		return conn;
	}

	protected void endConnection(PreparedStatement stmt, Connection conn) throws SQLException {
		if (stmt != null) {
			stmt.close();
		}
		if (conn != null) {
			conn.close();
		}
	}
}
