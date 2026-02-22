package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.dao.LoginDAO;
import com.exceptions.MyExcetpion;
import com.interfaces.LoginInterface;
import com.model.RegisterModel;

public class LoginService {

	LoginDAO loginDAO = new LoginDAO();

	public boolean userLogin(String email, String password) {

		LoginInterface loginInterface = (useremail, userpassword) -> {
			boolean b = false;
			ResultSet rs;
			try {
				rs = loginDAO.checkUser(email, password);
				if (rs.next() == false) {
					b = false;
				} else {
					b = true;
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return b;

		};

		boolean userLoginStatus = loginInterface.userLogin(email, password);
		return userLoginStatus;

	}

	public RegisterModel getUserDetails(String emailid) throws ClassNotFoundException, SQLException, MyExcetpion {

		RegisterModel rm = new RegisterModel();
		ResultSet rs = loginDAO.checkUser(emailid);
		if (rs.next() == false) {
			throw new MyExcetpion("something went wrong in getting the user details");
		}
		do {
			rm.setUserid(Integer.parseInt(rs.getString(1)));
			rm.setName(rs.getString(2));
			rm.setEmailid(rs.getString(3));
			rm.setPassword(rs.getString(4));
			rm.setDepartment(rs.getString("department"));

		} while (rs.next());

		return rm;
	}

}
