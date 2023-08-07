package com.telecom.DTO;

public class CreateCustRequestDTO {
	
	private String custName;
	private String custEmail;
	private String userUsername;
	private String userPassword;
	private long custPinCode;
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustEmail() {
		return custEmail;
	}
	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
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
	public long getCustPinCode() {
		return custPinCode;
	}
	public void setCustPinCode(long custPinCode) {
		this.custPinCode = custPinCode;
	}

	
	
}
