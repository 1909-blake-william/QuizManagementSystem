package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet {
	//Instancde Variables
	
	//service
	/*@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(req.getRequestURL());
		resp.addHeader("Access-Control-Allow-Origin", "http://localhost:8080");
		resp.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
		resp.addHeader("Access-Control-Allow-Headers",
				"Origin, Methods, Credentials, X-Requested-With, Content-Type, Accept");
		resp.addHeader("Access-Control-Allow-Credentials", "true");
		resp.setContentType("application/json");
		// TODO Auto-generated method stub
		super.service(req, resp);

	}*/
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
		
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		
	}
	
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) {
		
	}
	
}
