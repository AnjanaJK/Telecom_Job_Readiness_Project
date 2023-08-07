package com.telecom.DTO;

public class TicketCreateDTO {
	
	private String custName;
	private String custAddress;
	private long custPinCode;
	private String problemDesc;
	private String selectedProblem;
	private String custPhoneNo;
	
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustAddress() {
		return custAddress;
	}
	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}
	public long getCustPinCode() {
		return custPinCode;
	}
	public void setCustPinCode(long custPinCode) {
		this.custPinCode = custPinCode;
	}
	public String getProblemDesc() {
		return problemDesc;
	}
	public void setProblemDesc(String problemDesc) {
		this.problemDesc = problemDesc;
	}
	public String getSelectedProblem() {
		return selectedProblem;
	}
	public void setSelectedProblem(String selectedProblem) {
		this.selectedProblem = selectedProblem;
	}
	public String getCustPhoneNo() {
		return custPhoneNo;
	}
	public void setCustPhoneNo(String custPhoneNo) {
		this.custPhoneNo = custPhoneNo;
	}
	
}
