package com.entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCcon {
	static Connection c = null;
	static Statement stmt = null;

	public static void createTable(Details details) {
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Sree@123");
			System.out.println("Opened database successfully");

			stmt = c.createStatement();
			String sql = "CREATE TABLE Detailsf (NAME TEXT NOT NULL,EMAIL TEXT NOT NULL, PASSWORD TEXT NOT NULL, MOBILE_NO VARCHAR(10) NOT NULL, DATE_OF_BIRTH TEXT NOT NULL,  GENDER TEXT NOT NULL );";
			stmt.executeUpdate(sql);
			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Table created successfully");

	}

	public static void save(Details details) {
		try {
//			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Sree@123");

			System.out.println("Opened database successfully");
			stmt = c.createStatement();
			String sql = "INSERT INTO Detailsform(\r\n"
					+ "	name, email, password, mobile_no, date_of_birth , gender)\r\n" + "	VALUES (?, ?, ?, ?, ?, ?);";

			PreparedStatement ps = c.prepareStatement(sql);

			ps.setString(1, details.getName());
			ps.setString(2, details.getEmail());
			ps.setString(3, details.getPassword());
			ps.setString(4, details.getNumber());
			ps.setString(5, details.getDob());
			ps.setString(6, details.getGender());

			int rowsInserted = ps.executeUpdate();
			System.out.println(rowsInserted + " rows inserted.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

}
