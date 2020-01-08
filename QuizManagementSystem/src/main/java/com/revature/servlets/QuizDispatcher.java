package com.revature.servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class QuizDispatcher implements DispatcherServices {
	//Instance Variables
	private ServletFilter filter = ServletFilter.getFilter();
		
	@Override
	public void performService(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		if(filter.createQuiz(request)) {
		
		} else if (filter.createQuizQuestions(request)) {
			
		} else if (filter.getCurrentQuizzesHomePage(request)) {
			QuizHandler.handleGetAllQuizzes(request, response);
		} else if (filter.getGrades(request)) {
			
		} else if (filter.getPastQuizzesHomePage(request)) {
			
		} 
	}

	@Override
	public boolean supports(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return filter.createQuiz(request) ||
				filter.createQuizQuestions(request) ||
				filter.getCurrentQuizzesHomePage(request) ||
				filter.getGrades(request) ||
				filter.getPastQuizzesHomePage(request);
	}
}
