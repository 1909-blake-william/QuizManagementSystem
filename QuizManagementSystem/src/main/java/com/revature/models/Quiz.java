package com.revature.models;

public class Quiz {
	//Instance Variables
	private int quizId;
	private String subject, description;
	
	
	public Quiz(int id, String subject, String description) {
		super();
		this.quizId = id;
		this.subject = subject;
		this.description = description;
	}

	public int getId() {
		return quizId;
	}

	public void setId(int id) {
		this.quizId = id;
	}
	
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Quiz [id=" + quizId + ", subject=" + subject + ", description=" + description + "]";
	}

	
	
}
