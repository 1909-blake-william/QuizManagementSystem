package com.revature.daos;

import java.util.List;

import com.revature.models.Quiz;
import com.revature.models.User;

public interface QuizDao {

	int saveQuiz(Quiz newQuiz);
	int saveResults(User currentUser, int grade);
	int getQuizScores(User currentUser);
	int getUserBatch(User currentUser);
	int getResults(User currentUser);
	Quiz getQuizById(int quizId);
	List<Quiz> getAllQuizzes();
}
