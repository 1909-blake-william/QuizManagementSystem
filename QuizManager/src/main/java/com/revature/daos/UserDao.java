package com.revature.daos;

import com.revature.models.User;

public interface UserDao {
	User findByUsernameAndPassword(String username, String password);
	User findByUsername(String username);
	int saveUser(User newUser);
	User findByGeneralInfo(String firstname, String lastname, String email);
	int updatePassword(User currentUser);
}
