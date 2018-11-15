package com.example.web;

import java.util.*;
import com.example.model.*;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
/**
 * Servlet implementation class BeerSelect
 */
public class BeerSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String c = request.getParameter("color");
		BeerExpert be = new BeerExpert();
		List<String> result = be.getBrands(c);
		
//		response.setContentType("text/html");
//		PrintWriter out = response.getWriter();
//		out.println("Beer Selection Advice<br>");
//		
//		Iterator it = result.iterator();
//		while(it.hasNext()) {
//			out.print("<br>try: " + it.next());
//		}
		request.setAttribute("styles", result);
		
		RequestDispatcher view = 
				request.getRequestDispatcher("result.jsp");
		view.forward(request,response);
	}
}
