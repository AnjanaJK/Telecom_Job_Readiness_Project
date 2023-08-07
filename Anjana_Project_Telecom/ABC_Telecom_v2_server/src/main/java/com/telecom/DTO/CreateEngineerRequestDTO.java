package com.telecom.DTO;

public class CreateEngineerRequestDTO {

	private String engineerName;
	private String userUsername;
	private String userPassword;
	private int selectedManager;
	
	public String getEngineerName() {
		return engineerName;
	}
	public void setEngineerName(String engineerName) {
		this.engineerName = engineerName;
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
	public int getSelectedManager() {
		return selectedManager;
	}
	public void setSelectedManager(int selectedManager) {
		this.selectedManager = selectedManager;
	}
	
}
