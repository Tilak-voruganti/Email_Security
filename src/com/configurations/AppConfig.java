package com.configurations;

import com.dao.DAO;
import com.model.EmailModel;
import com.model.KycModel;
import com.service.EmailSearchService;
import com.service.EmailService;

public class AppConfig {
	
	public static KycModel getKycmodel() {
		return new KycModel();
	}
	
	public static DAO getDao() {
	   return new DAO();
	}
	
	public static EmailModel getEmailModel() {
		return new EmailModel();
	}
	
	public static EmailService getEmailService() {
		return new EmailService();
	}
	
	public static EmailSearchService getEmailSearchService() {
		return new EmailSearchService();
	}

}
