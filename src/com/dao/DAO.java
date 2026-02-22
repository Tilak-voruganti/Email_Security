package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;

import com.configurations.AppConfig;
import com.database.DbConnection;
import com.model.EmailModel;
import com.model.KycModel;
import com.model.RegisterModel;
import com.utils.HashCodeGenearate;
import com.utils.TrippleDes;

public class DAO {

	public int registerUser(RegisterModel rm) throws ClassNotFoundException, SQLException {

		Connection con = DbConnection.getCon();
		String sql = "insert into register values(0,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, rm.getName());
		ps.setString(2, rm.getEmailid());
		ps.setString(3, rm.getPassword());
		ps.setString(4, rm.getDepartment());
		int statusReg = ps.executeUpdate();
		return statusReg;
	}

	public ResultSet getEmails() throws ClassNotFoundException, SQLException {
		Connection con = DbConnection.getCon();
		String sql = "select * from register";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		return rs;
	}
	public ResultSet getEmails(String email,String type) throws ClassNotFoundException, SQLException {
		Connection con = DbConnection.getCon();
		String sql=null;
		sql=type.equalsIgnoreCase("inbox")
				?"select * from emailtable where toEmail='"+email+"'"
				:"select * from emailtable where fromEmail='"+email+"'";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		return rs;
	}
	public ResultSet getEmails1() throws ClassNotFoundException, SQLException {
		Connection con = DbConnection.getCon();
		String sql = "select emailid from register";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		return rs;
	}
	
	public ResultSet getEmailsforKey(String keyword) throws ClassNotFoundException, SQLException {
		Connection con = DbConnection.getCon();
		String sql = "SELECT *"
				+ "FROM emailtable "
				+ " WHERE keywords LIKE '%"+keyword+"%'";
		//System.out.println("the sql isssss"+sql);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		return rs;
	}
	public ResultSet getDept() throws ClassNotFoundException, SQLException {
		Connection con = DbConnection.getCon();
		String sql = "select department from register";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		return rs;
	}

	public int insertKyc(KycModel km) throws ClassNotFoundException, SQLException {

		int statusReg = 0;
		Connection con = DbConnection.getCon();
		String sql = "insert into userfiles values(0,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setBinaryStream(1, km.getInputStream());
		ps.setString(2, new Date().toString());
		ps.setInt(3, km.getUserid());
		ps.setString(4, km.getHashValue());
		ps.setString(5, km.getName());
		ps.setString(6, km.getFatherName());
		ps.setString(7, km.getMotherName());
		ps.setString(8, km.getMobile());
		ps.setString(9, km.getAddress());
		ps.setString(10, "");
		statusReg = ps.executeUpdate();
		return statusReg;

	}

	public ResultSet getKyc(int userid) throws ClassNotFoundException, SQLException {
		Connection con = DbConnection.getCon();
		String sql = "select * from userfiles where userid="+userid ;
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		return rs;
	}
	
	public ResultSet getKyc(String keyword) throws ClassNotFoundException, SQLException {
		Connection con = DbConnection.getCon();
		String sql = "select * from filterkeywords where keywords="+keyword ;
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		return rs;
	}

	public int insertEmail(EmailModel em) throws Exception {
		int statusReg = 0;
		Connection con = DbConnection.getCon();
		String sql = "insert into emailtable values(0,?,?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, em.getFromEmail());
		ps.setString(2, em.getToEmail());
		ps.setString(3, em.getSubject());
		ps.setString(5, em.getBody());
		ps.setString(4, em.getDept());
		//String s1= AppConfig.getEmailService().convertToString(sql)
		ps.setString(6, em.getKeywords());
		String s[]=  LocalDate.now().toString().split(" ");
		ps.setString(7,s[0]);
		statusReg = ps.executeUpdate();
		if(statusReg!=-1) {
			
			String sql1 = "SELECT *FROM emailtable ORDER BY id DESC LIMIT 1";
			PreparedStatement ps1 = con.prepareStatement(sql1);
			
			ResultSet rs = ps1.executeQuery();
			if(rs.next()) {
				
				String sql2="insert into filterkeywords values(?,?,?,?)";
				 ps1=con.prepareStatement(sql2);
				 ps1.setInt(1, rs.getInt(1));
				 ps1.setString(2,rs.getString(2));
				 ps1.setString(3, TrippleDes.passwrodEnc(rs.getString(7), "enc"));
				
				 ps1.setString(4, HashCodeGenearate.getHashValue(rs.getString(2)));
				 ps1.executeUpdate();
				
			}
			
			
		}
		return statusReg;
		
	}

	public ResultSet getKeyWords() throws ClassNotFoundException, SQLException {
		Connection con = DbConnection.getCon();
		String sql = "select keywords from filterkeywords";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		return rs;
	}

	public ResultSet getUsers() throws ClassNotFoundException, SQLException {
		Connection con = DbConnection.getCon();
		String sql = "select * from register";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		return rs;
	}

}
