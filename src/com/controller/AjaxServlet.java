package com.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.google.gson.Gson;
import com.utils.ProductModel;

@WebServlet("/ajax")
public class AjaxServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public AjaxServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//System.out.println("in search ");
		Gson gson = new Gson();
		String term = request.getParameter("term");
		ProductModel productModel = new ProductModel();
		PrintWriter out = response.getWriter();
		try {
			out.print(gson.toJson(productModel.search(term)));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.flush();
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}