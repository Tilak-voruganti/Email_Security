package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.configurations.AppConfig;
import com.google.gson.Gson;
import com.service.EmailService;

@WebServlet("/search")
public class KeywordSearch  extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		//System.out.println("in search ");
		Gson gson = new Gson();
		String term = req.getParameter("term");
		try {
			List<String> results=AppConfig.getEmailService().getKeywords(term);
			List<String> res=new ArrayList();
			for(String s:results) {
				
				if(s.contains(",")) {
					String s1[]=s.split(",");
					for(String s2:s1) {
						res.add(s2);
					}
				}else {
					res.add(s);
				}
			}
			
		List<String> res1=res.stream().distinct().collect(Collectors.toList());
			
			out.println(gson.toJson(res1));
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
