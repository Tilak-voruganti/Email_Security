package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.configurations.AppConfig;
import com.model.EmailModel;
import com.utils.TrippleDes;

public class EmailService {
	
	public boolean insertEmail(EmailModel em) throws Exception {
		
		int i= AppConfig.getDao().insertEmail(em);
		if(i==-1) {
			return false;
		}
		return true;
		
	}
	
	public List<EmailModel> getEmails(String email,String type) throws Exception{
		
		ResultSet rs=AppConfig.getDao().getEmails(email,type);
		
		List<EmailModel> emails=new ArrayList<>();
		
		emails=type.equalsIgnoreCase("inbox")?inboxEmail(rs):sentEmail(rs);
				
				
		return emails;
	}

	private List<EmailModel> inboxEmail(ResultSet rs) throws SQLException {
		List<EmailModel> emails=new ArrayList<>();
		while(rs.next()) {
			EmailModel em=AppConfig.getEmailModel();
			em.setFromEmail(rs.getString("fromEmail"));
			em.setSubject(rs.getString("subject"));
			em.setDate(rs.getString("date"));
		
			emails.add(em);
		}
		return emails;
	}

	private List<EmailModel> sentEmail(ResultSet rs) throws Exception {
		List<EmailModel> emails=new ArrayList<>();
		while(rs.next()) {
			EmailModel em=AppConfig.getEmailModel();
			em.setFromEmail(rs.getString("toEmail"));
			em.setSubject(rs.getString("subject"));
			em.setDate(rs.getString("date"));
			String s=rs.getString("keywords");
			//System.out.println("the keywords are"+convertToString(s));
			emails.add(em);
			getKeywords("sample");
		}
		return emails;
	}
	
	public List<String> getKeywords(String keywords) throws Exception {
		
		List<String> keyWords=new ArrayList<String>();
		ResultSet rs=AppConfig.getDao().getKeyWords();
		while(rs.next()) {
			
			String enct=TrippleDes.passwrodEnc(rs.getString(1), "decr");
		//	String s=convertToString(enct);
			//System.out.println(enct);
			
			try {
				//String s1[]=enct.split(",");
				keyWords.add(enct);
			}catch(Exception e) {
				//System.out.println("no , in keywords");
			}
		}
		
		return keyWords;
	}
	
	public String convertToString(String str) {
		StringBuilder sb=new StringBuilder();
		sb.append(str);
		return sb.substring(1,sb.length()-1);
	}

}
