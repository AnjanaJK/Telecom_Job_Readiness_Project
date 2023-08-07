package com.telecom.DTO;

public class fetchManagerDTO {
	
	private int managerId;
    private String managerName;
    private Long managerPinCode;
    private int userId;
    private String userUsername;
    private String userPassword;
    
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public Long getManagerPinCode() {
		return managerPinCode;
	}
	public void setManagerPinCode(Long managerPinCode) {
		this.managerPinCode = managerPinCode;
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

}
