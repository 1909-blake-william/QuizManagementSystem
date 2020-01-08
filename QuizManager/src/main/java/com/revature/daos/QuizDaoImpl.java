package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.revature.models.Quiz;
import com.revature.models.User;

public class QuizDaoImpl implements QuizDao{
	//Instance Variables
	private static DataSource ds;
	private static final QuizDao instance = new QuizDaoImpl(ds);
	
	Quiz extractQuiz(ResultSet rs) throws SQLException{
		//quizId, subject, description
		int quizId = rs.getInt("QUIZ_ID");
		String subject = rs.getString("SUBJECT");
		String description = rs.getString("QUIZ_DESCRIPTION");
		
		return new Quiz(quizId, subject, description);
	}
	
	public QuizDaoImpl(DataSource ds) {
		QuizDaoImpl.ds = ds;
	}
	
	/*This method is faulty*/
	@Override
	public int saveResults(User currentUser, int grade) {
		// TODO Auto-generated method stub
		try {
			Connection database = ds.getConnection();
			String selectStatement = "SELECT quiz_id from batch_group where group_id = ?";
			String statement = "INSERT INTO results(user_id, quiz_id, grade, results_id)\\r\\n\" + \r\n" + 
								"VALUES(?,?,?,?)";
			PreparedStatement selectPs = database.prepareStatement(selectStatement);
			//I need batch id so that I can find corresponding quiz id
			selectPs.setInt(1, currentUser.getGroupId());
			//save this in result set to be used later
			ResultSet rs = selectPs.executeQuery();
			
			PreparedStatement ps = database.prepareStatement(statement);
			
			ps.setInt(1, currentUser.getUserId());
			//calling quiz id from select statement
			ps.setInt(2, rs.getInt("quiz_id"));
			ps.setInt(3, grade);
			ps.setInt(4, currentUser.getResultsId());
			
			
			return ps.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
			return 0;
		}
		
	}

	@Override
	public int saveQuiz(Quiz newQuiz) {
		// TODO Auto-generated method stub
		try {
			Connection database = ds.getConnection();
			String statement = "INSERT INTO quiz(quiz_id, subject, quiz_description)\r\n" + 
					"VALUES(QUIZ_ID_SEQ.nextval,?,?)";
			
			PreparedStatement ps = database.prepareStatement(statement);
			ps.setString(1, newQuiz.getSubject());
			ps.setString(2, newQuiz.getDescription());
			
			return ps.executeUpdate();
		
		} catch(SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	public static QuizDao getInstance() {
		return instance;
	}


	@Override
	public int getQuizScores(User currentUser) {
		// TODO Auto-generated method stub
		try {
			Connection database = ds.getConnection();
			String statement = "SELECT grade from results WHERE user_id = ?";
			
			PreparedStatement ps = database.prepareStatement(statement);
			ps.setInt(1, currentUser.getUserId());
			
			return ps.executeUpdate();
		
		} catch(SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int getUserBatch(User currentUser) {
		try {
			Connection database = ds.getConnection();
			String selectStatement = "SELECT group_id from batch_group where group_id = ?";
			PreparedStatement selectPs = database.prepareStatement(selectStatement);
			selectPs.setInt(1, currentUser.getGroupId());
			
			return selectPs.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int getResults(User currentUser) {
		try {
			Connection database = ds.getConnection();
			String selectStatement = "SELECT grade from results where user_id = ?";
			PreparedStatement selectPs = database.prepareStatement(selectStatement);
			
			selectPs.setInt(1, currentUser.getUserId());
			
			
			return selectPs.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public Quiz getQuizById(int quizId) {
		// TODO Auto-generated method stub
		try {
			Connection database = ds.getConnection();
			String selectStatement = "SELECT * from quiz where quiz_id = ?";
			PreparedStatement selectPs = database.prepareStatement(selectStatement);
			
			selectPs.setInt(1, quizId);
			
			ResultSet rs = selectPs.executeQuery();
			if (rs.next()) {
				return extractQuiz(rs);
			} else {
				return null;
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Quiz> getAllQuizzes() {
		try {
			List<Quiz> quizzes = new ArrayList<Quiz>();
			Connection database = ds.getConnection();
			String selectStatement = "SELECT * from quiz";
			PreparedStatement selectPs = database.prepareStatement(selectStatement);
		
			ResultSet rs = selectPs.executeQuery();
			while (rs.next()) {
				quizzes.add(extractQuiz(rs));
			}
			return quizzes;
			
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
