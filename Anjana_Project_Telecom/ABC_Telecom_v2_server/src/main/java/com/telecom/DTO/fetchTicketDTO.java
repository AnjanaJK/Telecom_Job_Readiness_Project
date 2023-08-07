package com.telecom.DTO;

import java.time.LocalDate;

public class fetchTicketDTO {

	private int ticketId;
	private String custName;
	private String custAddress;
	private Long custPinCode;
	private String problemDesc;
	private String problemType;
	private String custPhoneNo;
	private LocalDate ticketDate;
    private String status;
    private String assignedEngineer;
    
	public int getTicketId() {
		return ticketId;
	}
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
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
	public Long getCustPinCode() {
		return custPinCode;
	}
	public void setCustPinCode(Long custPinCode) {
		this.custPinCode = custPinCode;
	}
	public String getProblemDesc() {
		return problemDesc;
	}
	public void setProblemDesc(String problemDesc) {
		this.problemDesc = problemDesc;
	}
	public String getProblemType() {
		return problemType;
	}
	public void setProblemType(String problemType) {
		this.problemType = problemType;
	}
	public String getCustPhoneNo() {
		return custPhoneNo;
	}
	public void setCustPhoneNo(String custPhoneNo) {
		this.custPhoneNo = custPhoneNo;
	}
	public LocalDate getTicketDate() {
		return ticketDate;
	}
	public void setTicketDate(LocalDate ticketDate) {
		this.ticketDate = ticketDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAssignedEngineer() {
		return assignedEngineer;
	}
	public void setAssignedEngineer(String assignedEngineer) {
		this.assignedEngineer = assignedEngineer;
	}
}
