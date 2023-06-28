package com.AIP.Student;

import java.sql.*;

public class DBConnection {
	
	public static void inserData(String title, String author, String publisher, String price, String stock)
	{
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "shadow");
			String query = "insert into libraryBooks values(?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, title);
			pstmt.setString(2, author);
			pstmt.setString(3, publisher);
			pstmt.setString(4, price);
			pstmt.setString(5, stock);
			pstmt.executeUpdate();
			con.close();
		} 
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static void updateData(String nTitle, String nAuthor, String nPublisher, String nPrice, String nStock, String modifySearchTitle)
	{
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "shadow");
			String query = "update libraryBooks set title=?,author=?,publisher=?,price=?,stock=? where title=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, nTitle);
			pstmt.setString(2, nAuthor);
			pstmt.setString(3, nPublisher);
			pstmt.setString(4, nPrice);
			pstmt.setString(5, nStock);
			pstmt.setString(6, modifySearchTitle);
			pstmt.executeUpdate();
			con.close();
		} 
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static long priceBooks(String nTitle, String nAuthor, String issueCopy)
	{
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "shadow");
			String query = "update libraryBooks set stock = stock - ? where title=? and author = ?";
			String query1 = "select price from libraryBooks where title=? and author = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			PreparedStatement pstmt1 = con.prepareStatement(query1);
			pstmt.setString(1, issueCopy);
			pstmt.setString(2, nTitle);
			pstmt.setString(3, nAuthor);
			pstmt1.setString(1, nTitle);
			pstmt1.setString(2, nAuthor);
			pstmt.executeUpdate();
			pstmt1.executeUpdate();
			ResultSet rs = pstmt1.executeQuery();
			while(rs.next()) {
				long price = Integer.parseInt(rs.getString(1)) * Integer.parseInt(issueCopy);
				rs.close();
				con.close();
				return price;
			}
		} 
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}
	
	public static void deleteData(String dTitle, String dAuthor)
	{
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "shadow");
			String query = "delete from libraryBooks where title=? and author=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, dTitle);
			pstmt.setString(2, dAuthor);
			pstmt.executeUpdate();
			con.close();
		} 
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static long stockAvailable(String searTitle, String searAuthor) {
		long result;
		try {
//			Attributes: Name, DOB, Mobile no., address, pan no, password
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "shadow");
			String query = "select stock from libraryBooks where title = ? and author = ?";
			PreparedStatement prst = con.prepareStatement(query);
			prst.setString(1, searTitle);
			prst.setString(2, searAuthor);
			prst.executeUpdate();
			ResultSet rs = prst.executeQuery();
			while(rs.next()) {
				result = Integer.parseInt(rs.getString(1));
				rs.close();
				con.close();
				return result;
			}
		} 
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}
}



