package com.ys.workdaily.pojo;

public class User {

	private String id;
	private String userName;
	private String password;
	private Integer age;
	
	public User() {
		
	}

	public User(String id, String userName, String password, Integer age) {
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.age = age;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}
