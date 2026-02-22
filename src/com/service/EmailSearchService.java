package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.configurations.AppConfig;
import com.model.EmailModel;
import com.model.RegisterModel;

public class EmailSearchService {

	public List<EmailModel> getEmailsForKey(String keyword) throws ClassNotFoundException, SQLException {

		List<EmailModel> emails = new ArrayList<>();
		ResultSet rs = AppConfig.getDao().getEmailsforKey(keyword);
		while (rs.next()) {
			EmailModel em = AppConfig.getEmailModel();
			em.setSubject(rs.getString("subject"));
			em.setFromEmail(rs.getString("fromEmail"));
			em.setDate(rs.getString("date"));
			em.setDept(rs.getString("dept"));
			em.setBody(rs.getString("body"));
			emails.add(em);

		}
		return emails;

	}
	
	public List<RegisterModel> getUsers() throws ClassNotFoundException, SQLException {

		List<RegisterModel> emails = new ArrayList<>();
		ResultSet rs = AppConfig.getDao().getUsers();
		while (rs.next()) {
			RegisterModel em = new RegisterModel();
			em.setEmailid(rs.getString("emailid"));
			em.setName(rs.getString("username"));
			em.setUserid(rs.getInt("userid"));
			em.setDepartment(rs.getString("department"));
			emails.add(em);

		}
		return emails;

	}


}
