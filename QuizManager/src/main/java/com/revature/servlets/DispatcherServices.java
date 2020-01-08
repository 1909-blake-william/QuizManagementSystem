package com.revature.servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface DispatcherServices {
	void performService(HttpServletRequest request, HttpServletResponse response);
	boolean supports(HttpServletRequest request);
}
