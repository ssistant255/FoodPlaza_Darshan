package com.foodplaza.utility;
import java.sql.*;
public class DBUtility 
{
	public static Connection establishConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/foodplaza_darshan1","root","darshan3009");
		return conn;
	}
}
