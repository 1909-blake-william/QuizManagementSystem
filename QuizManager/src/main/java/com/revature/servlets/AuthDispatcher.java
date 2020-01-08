package com.revature.servlets;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.daos.UserDao;
//import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.daos.UserDaoImpl;
import com.revature.models.User;
import com.revature.util.Json;
import com.revature.servlets.ServletFilter;

public class AuthDispatcher implements DispatcherServices{
	private UserDao userDao = UserDaoImpl.getInstance();
	private ServletFilter filter = ServletFilter.getFilter();

	@Override
	public void performService(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			User credentials = (User) Json.read(request.getInputStream(), User.class);
			User loggedInUser = userDao.findByUsernameAndPassword
					(credentials.getUsername(), credentials.getPassword());
			if (loggedInUser != null) {
				//I will refer to this session later on
				request.getSession().setAttribute("user", loggedInUser);
				response.setContentType(Json.CONTENT_TYPE);
				Json.write(loggedInUser);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean supports(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return filter.createLogin(request) || filter.getLoginPage(request);
	}
}
