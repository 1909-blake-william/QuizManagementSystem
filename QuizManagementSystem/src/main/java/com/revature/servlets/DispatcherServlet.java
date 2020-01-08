package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class DispatcherServlet extends HttpServlet {
	//Instancde Variables
	private static final long serialVersionUID = 1L;
	private final Logger logger = LogManager.getLogger(getClass());
	private final DispatcherServices dispatcherHandler = DispatcherHandler.getInstance();
	
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
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (dispatcherHandler.supports(req)) {
			dispatcherHandler.performService(req, resp);
		} else {
			resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// We need to configure the different options such that our application
		// can RESPOND to any client, as long as it's a valid request to our resource
		logger.info("{} request coming to {}", req.getMethod(), req.getRequestURI());
		if (dispatcherHandler.supports(req)) {
			dispatcherHandler.performService(req, resp);
		} else {
			resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
	}
	
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) {
		
	}
	
}
