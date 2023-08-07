package com.telecom.Entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Complaint {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ticketId;
	
	@Column(name="cust_name")
	private String custName;
	
	@Column(name="address")
	private String address;
	
	@Column(name="pin_code")
	private Long pinCode;
	
	@Column(name="problem_desc")
	private String problemDesc;
	
	@Column(name="problem_type")
	private String problemType;
	
	@Column(name="tel_mob_no")
	private String telMobNo;
	
	@Column(name="ticket_date")
	private LocalDate ticketDate;
	
	@Column(name = "status")
    private String status; // Values: "RESOLVED", "ESCALATED", "RAISED"
	
    @ManyToOne
    @JoinColumn(name = "engineer_id")
//    @JsonIgnoreProperties("assignedEngineer")
    private Engineer assignedEngineer;
	
	// FK Cust table
	@ManyToOne
	@JoinColumn(name="cust_id")
	@JsonIgnoreProperties("complaints")
	private Customer custComplaint;
	
	@OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TicketComment> comments;
	
//	---------------------------------
	
	public Complaint() {
		// TODO Auto-generated constructor stub
	}


	public Complaint(int ticketId, String custName, String address, Long pinCode, String problemDesc,
			String problemType, String telMobNo, LocalDate ticketDate, String status, Engineer assignedEngineer,
			Customer custComplaint, List<TicketComment> comments) {
		super();
		this.ticketId = ticketId;
		this.custName = custName;
		this.address = address;
		this.pinCode = pinCode;
		this.problemDesc = problemDesc;
		this.problemType = problemType;
		this.telMobNo = telMobNo;
		this.ticketDate = ticketDate;
		this.status = status;
		this.assignedEngineer = assignedEngineer;
		this.custComplaint = custComplaint;
		this.comments = comments;
	}


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
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public Long getPinCode() {
		return pinCode;
	}
	
	public void setPinCode(Long pinCode) {
		this.pinCode = pinCode;
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
	
	public String getTelMobNo() {
		return telMobNo;
	}
	
	public void setTelMobNo(String telMobNo) {
		this.telMobNo = telMobNo;
	}

	public Customer getCustComplaint() {
		return custComplaint;
	}

	public void setCustComplaint(Customer custComplaint) {
		this.custComplaint = custComplaint;
	}

	public Engineer getAssignedEngineer() {
		return assignedEngineer;
	}

	public void setAssignedEngineer(Engineer assignedEngineer) {
		this.assignedEngineer = assignedEngineer;
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

	
	public List<TicketComment> getComments() {
		return comments;
	}


	public void setComments(List<TicketComment> comments) {
		this.comments = comments;
	}


	@Override
	public String toString() {
		return "Complaint [ticketId=" + ticketId + ", custName=" + custName + ", address=" + address + ", pinCode="
				+ pinCode + ", problemDesc=" + problemDesc + ", problemType=" + problemType + ", telMobNo=" + telMobNo
				+ ", ticketDate=" + ticketDate + ", status=" + status + ", assignedEngineer=" + assignedEngineer
				+ ", custComplaint=" + custComplaint + ", comments=" + comments + "]";
	}


	
//	@Override
//	public String toString() {
//		return "Complaint [ticketId=" + ticketId + ", custName=" + custName + ", address=" + address + ", pinCode="
//				+ pinCode + ", problemDesc=" + problemDesc + ", problemType=" + problemType + ", telMobNo=" + telMobNo
//				+ ", ticketDate=" + ticketDate + ", status=" + status + ", assignedEngineer=" + assignedEngineer
//				+ ", custComplaint=" + custComplaint + "]";
//	}

//	 OLDER
//	@Override
//	public String toString() {
//		return "Complaint [ticketId=" + ticketId + ", custName=" + custName + ", address=" + address + ", pinCode="
//				+ pinCode + ", problemDesc=" + problemDesc + ", problemType=" + problemType + ", telMobNo=" + telMobNo
//				+ ", ticketDate=" + ticketDate + ", status=" + status + ", custComplaint=" + custComplaint + "]";
//	}
	
	



}
