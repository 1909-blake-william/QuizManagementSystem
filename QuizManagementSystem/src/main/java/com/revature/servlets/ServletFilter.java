package com.revature.servlets;
/**
 * author: Kamilah Carlisle
 * Date due: Jane 6, 2020
 * description: this class will be used by a servlet to determine what page an app is currently on
 * and therefore determine how the servlet will behave
 */

import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;

public class ServletFilter{
	//Instance variables
	private static final ServletFilter filter = new ServletFilter();
	//this request uri is very vague, might cause problems later
	//test this method
	
	public boolean getLoginPage(HttpServletRequest request) {
		if (request.getMethod().contentEquals("GET") &&
				request.getRequestURI().equals("/QuizManagementSystem/api/login/")) {
			return true;
		} else {
			return false;
		}
	}
	public boolean createLogin(HttpServletRequest request) {
		if (request.getMethod().contentEquals("POST") &&
				request.getRequestURI().equals("/QuizManagementSystem/api/login/")) {
			return true;
		} else {
			return false;
		}
	}
	//test this method
	public boolean getCurrentQuizzesHomePage(HttpServletRequest request) {
		if (request.getMethod().equals("GET") && 
			request.getRequestURI().equals("/QuizManagementSystem/api/currentquizzes/")) {
			return true;
		} else {
			return false;
		}
		
	}
	
	public boolean getPastQuizzesHomePage(HttpServletRequest request) {
		if (request.getMethod().contentEquals("GET") && 
			request.getRequestURI().equals("/QuizManager/api/past quizzes/")) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean getGrades(HttpServletRequest request) {
		if (request.getMethod().contentEquals("GET") &&
			request.getRequestURI().equals("/QuizManager/api/grades/*")) {
			return true;
		} else {
			return false;
		}
	}
	public boolean createQuiz(HttpServletRequest request) {
		if (request.getMethod().contentEquals("POST") &&
				request.getRequestURI().equals("/QuizManager/api/current quizzes/create new quiz")) {
			return true;
		} else {
			return false;
		}
	}
	//test this method
	public boolean createQuizQuestions(HttpServletRequest request) {
		if (request.getMethod().contentEquals("POST") &&
				request.getRequestURI().equals("/QuizManager/api/current quizzes/create new quiz/*")) {
			return true;
		} else {
			return false;
		}
	}
	public static ServletFilter getFilter() {
		return filter;
	}
}
