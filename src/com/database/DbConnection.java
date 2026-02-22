package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	
	static Connection con=null;
	public static Connection getCon() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vtjcc04_2022","root","root");
		return con;
		
	}
	
	public static void main(String args[]) {
		
		try {
			con=DbConnection.getCon();
		//	String s= con==null?"false":"true";
			
			if(con==null) {
				//System.out.println("true");
			}else {
				//System.out.println("false");
			}
		//	//System.out.println();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
