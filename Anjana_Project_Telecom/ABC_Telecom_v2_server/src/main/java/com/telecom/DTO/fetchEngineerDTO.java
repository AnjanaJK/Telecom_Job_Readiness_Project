package com.telecom.DTO;

public class fetchEngineerDTO {
	private int engineerId;
    private String engineerName;
    private int selectedManager;
    private int userId;
    private String userUsername;
    private String userPassword;
    private String managerName;
    private long pinCode;
    
	public int getEngineerId() {
		return engineerId;
	}
	public void setEngineerId(int engineerId) {
		this.engineerId = engineerId;
	}
	public String getEngineerName() {
		return engineerName;
	}
	public void setEngineerName(String engineerName) {
		this.engineerName = engineerName;
	}
	public int getSelectedManager() {
		return selectedManager;
	}
	public void setSelectedManager(int selectedManager) {
		this.selectedManager = selectedManager;
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
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public long getPinCode() {
		return pinCode;
	}
	public void setPinCode(long pinCode) {
		this.pinCode = pinCode;
	}
       
}
