package com.telecom.DTO;

public class CreateManagerRequestDTO {
		
//	private String managerFullName;
	private String managerName;
	private String userUsername;
	private String userPassword;
	private long managerPinCode;
	
	
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
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
	public long getManagerPinCode() {
		return managerPinCode;
	}
	public void setManagerPinCode(long managerPinCode) {
		this.managerPinCode = managerPinCode;
	}
	
	
	
	
}
