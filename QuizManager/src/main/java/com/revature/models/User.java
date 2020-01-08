package com.revature.models;
public class User {
	
	//Instance Variables
	private String username, email, firstname, lastname, password;
	private int userId, typeId, groupId, resultsId;
	
	public User(int userId, int typeId, String username, String password, 
			String firstname, String lastname, String email, int groupId, int resultsId) {
		super();
		this.username = username;
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
		this.userId = userId;
		this.typeId = typeId;
		this.groupId = groupId;
		this.resultsId = resultsId;
	}
	
	//currentQuiz will contain the constructor with just quiz id and quiz grade
	public User(int userId, int resultsId) {
		super();
		this.userId = userId;
		this.resultsId = resultsId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public int getResultsId() {
		return resultsId;
	}
	public void setResultsId(int resultsId) {
		this.resultsId = resultsId;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", email=" + email + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", password=" + password + ", userId=" + userId + ", groupId=" + groupId +", resultsId=" + resultsId
				+ ", groupId =" + groupId + ", typeId=" + typeId + "]";
	}
	
}
