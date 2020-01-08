package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.revature.models.User;

public class UserDaoImpl implements UserDao {
	 private static DataSource ds;
	 private static final UserDao instance = new UserDaoImpl(ds);
	 /*public User(int userId, int typeId, String username, String password, 
			String firstname, String lastname, String email, int groupId, int resultsId) {*/
	 User extractUser(ResultSet rs) throws SQLException{
		 int userId = rs.getInt("user_id");
		 int typeId = rs.getInt("type_id");
		 String username = rs.getString("user_name");
		 String password = rs.getString("user_pass");
		 String firstname = rs.getString("firstname");
		 String lastname = rs.getString("lastname");
		 String email = rs.getString("email");
		 int groupId = rs.getInt("group_id");
		 int resultsId = rs.getInt("results_id");
		 return new User(userId, typeId, username, password, firstname, lastname, email, groupId, resultsId);
	 }
	//Singleton Object for Connection
	public UserDaoImpl(DataSource ds) {
		UserDaoImpl.ds = ds;
	}
	//Only return the user id and user name from the user object
	//Type id is also needed for log in check for admin
	@Override
	public User findByUsernameAndPassword(String username, String password) {
		// TODO Auto-generated method stub
		try {
			Connection database = ds.getConnection();
			//String statement = "SELECT * FROM Quiz_User WHERE USER_NAME = ? AND USER_PASS = ?";

			String statement = "SELECT user_name, user_id, type_id"
					+ "FROM Quiz_User WHERE USER_NAME = ? AND USER_PASS = ?";
			PreparedStatement ps = database.prepareStatement(statement);
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return extractUser(rs);
			} else {
				return null;
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	//Only return the user id and user name from the user object
	@Override
	public User findByUsername (String username){
		// TODO Auto-generated method stub
		try {
			Connection database = ds.getConnection();
			//String statement = "SELECT * FROM Quiz_User WHERE USER_NAME = ? AND USER_PASS = ?";

			String statement = "SELECT user_id, user_name"
					+ "FROM Quiz_User WHERE USER_NAME = ?";
			PreparedStatement ps = database.prepareStatement(statement);
			
			ps.setString(1, username);
			
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return extractUser(rs);
			} else {
				return null;
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	//Trainers will register a new user
	public int saveUser(User newUser) {
		// TODO Auto-generated method stub
		try {
			Connection database = ds.getConnection();
			//String statement = "SELECT * FROM Quiz_User WHERE USER_NAME = ? AND USER_PASS = ?";

			String statement = "INSERT INTO QUIZ_USER(user_id, type_id, user_name, user_pass, "
					+ "firstname, lastname, email, group_id, results_id)\r\n" + 
					"VALUES (user_id_seq.nextval, 2, '?', '?', '?', '?',"
					+ " '?', ?, results_id_seq.nextval);";
			PreparedStatement ps = database.prepareStatement(statement);
			/*int userId = rs.getInt("user_id");
			 int typeId = rs.getInt("type_id");
			 String username = rs.getString("user_name");
			 String password = rs.getString("user_pass");
			 String firstname = rs.getString("firstname");
			 String lastname = rs.getString("lastname");
			 String email = rs.getString("email");
			 int groupId = rs.getInt("group_id");
			 int resultsId = rs.getInt("results_id");*/
		
			ps.setString(2, newUser.getUsername());
			
			//Trainer will not be able to set trainee passwords
			ps.setString(3, null);
			ps.setString(4, newUser.getFirstname());
			ps.setString(5, newUser.getLastname());
			ps.setString(6, newUser.getEmail());
			
			ps.setInt(7, newUser.getGroupId());
			ps.setInt(8, newUser.getResultsId());
			
			return ps.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	
	public static UserDao getInstance() {
		return instance;
	}
	@Override
	public User findByGeneralInfo(String firstname, String lastname, String email) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int updatePassword(User currentUser) {
		try {
			Connection database = ds.getConnection();
			//String statement = "SELECT * FROM Quiz_User WHERE USER_NAME = ? AND USER_PASS = ?";

			String statement = "UPDATE quiz_user SET user_pass = ? WHERE user_name = ?";
			PreparedStatement ps = database.prepareStatement(statement);
			/*int userId = rs.getInt("user_id");
			 int typeId = rs.getInt("type_id");
			 String username = rs.getString("user_name");
			 String password = rs.getString("user_pass");
			 String firstname = rs.getString("firstname");
			 String lastname = rs.getString("lastname");
			 String email = rs.getString("email");
			 int groupId = rs.getInt("group_id");
			 int resultsId = rs.getInt("results_id");*/
			ps.setString(1, currentUser.getPassword());
			ps.setString(2, currentUser.getUsername());
			
			
			return ps.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

}
