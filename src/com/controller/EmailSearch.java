package com.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.configurations.AppConfig;
import com.model.EmailModel;

@WebServlet("/EmailSearch")
public class EmailSearch extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String keyword=req.getParameter("keyword");
		//System.out.println("inside email search"+keyword);
		
		try {
			List<EmailModel> emails= AppConfig.getEmailSearchService().getEmailsForKey(keyword);
			
			req.setAttribute("emails", emails);
            req.getRequestDispatcher("sendemail.jsp?page=search").forward(req, resp);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
