package com.telecom.Entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private int userId;
	
	@Column(name="username")
	private String userUsername;
	
	@Column(name="password")
	private String userPassword;
	
	@Column(name="role")
	private String userRole;
	
	@OneToMany(mappedBy = "userCust")
    private List<Customer> customers;
	
	@OneToMany(mappedBy = "userMngr")
    private List<Manager> managers;
	
	@OneToMany(mappedBy = "userEng")
    private List<Engineer> engineers;
	

//	-------------------------------------------------------
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(int userId, String userUsername, String userPassword, String userRole) {
		super();
		this.userId = userId;
		this.userUsername = userUsername;
		this.userPassword = userPassword;
		this.userRole = userRole;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserUsername() {
		return userUsername;
	}
	public void setUserUsername(String userUsername) {
		this.userUsername = userUsername;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	  @Override
	    public String toString() {
	        return "User{" +
	                "userId=" + userId +
	                ", username='" + userUsername + '\'' +
	                ", password='" + userPassword + '\'' +
	                ", role='" + userRole + '\'' +
	                // Avoid including the collections in the toString() representation
	                // ", customers=" + customers +
	                // ", managers=" + managers +
	                // ", engineers=" + engineers +
	                '}';
	}
	

}
