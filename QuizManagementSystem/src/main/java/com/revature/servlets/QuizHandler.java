package com.revature.servlets;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.daos.QuizDao;
import com.revature.daos.QuizDaoImpl;
import com.revature.models.Quiz;
import com.revature.util.Json;

public class QuizHandler {
	
	/*if(filter.createQuiz(request)) {
		
	} else if (filter.createQuizQuestions(request)) {
		
	} else if (filter.getCurrentQuizzesHomePage(request)) {
		
	} else if (filter.getGrades(request)) {
		
	} else if (filter.getPastQuizzesHomePage(request)) {*/
	
	private static final QuizDao quizDao = QuizDaoImpl.getInstance();
	private static final Logger logger = LogManager.getLogger(QuizHandler.class);
 

	
	public static void handleGetAllGrades(){
		
	}
	
	public static void handleGetOneGrade(HttpServletRequest request, HttpServletResponse response){
		
	}
	
	public static void handleGetAllQuizzes(HttpServletRequest request, HttpServletResponse response){
		List<Quiz> quizzes = quizDao.getAllQuizzes();
		if (quizzes.isEmpty()) {
			response.setStatus(HttpServletResponse.SC_NO_CONTENT);
			return;
		} else {
			response.setContentType(Json.CONTENT_TYPE);
			try {
				response.getOutputStream().write(Json.write(quizzes));
				return;
			} catch (IOException e) {
				logger.warn("Failed to write to Response Body: {}", e);
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				return;
			}
		}
	}
	
	public static void handleGetOneQuiz(HttpServletRequest request, HttpServletResponse response) {
		String[] path = request.getRequestURI().split("/");
		int quizId = Integer.parseInt(path[path.length - 1]);
		Quiz oneQuiz = quizDao.getQuizById(quizId);
		if (oneQuiz != null) {
			try {
				response.setContentType(Json.CONTENT_TYPE);
				response.getOutputStream().write(Json.write(oneQuiz));
			} catch(IOException e) {
				logger.warn("Failed to write to Response Body: {}", e);
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				return;
			}
		} else {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
	}
	
	
}
