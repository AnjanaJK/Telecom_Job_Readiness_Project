package com.telecom.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Engineer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int engineerId;
	
	//FK user
	@ManyToOne
	@JoinColumn(name="user_id")
	private User userEng;
	
	@Column(name="engineer_name")
	private String engineerName;
	
	// FK manager
	@JsonIgnore // Add this annotation to break the bidirectional relationship
	@ManyToOne
	@JoinColumn(name="manager_id")
	private Manager managerId;
	
	@OneToMany(mappedBy = "assignedEngineer")
	@JsonIgnore
    private List<Complaint> complaints;
	
//	---------------------------------------------------------
	
	public Engineer() {
		// TODO Auto-generated constructor stub
	}

	public Engineer(int engineerId, User userEng, String engineerName, Manager managerId, List<Complaint> complaints) {
	super();
	this.engineerId = engineerId;
	this.userEng = userEng;
	this.engineerName = engineerName;
	this.managerId = managerId;
	this.complaints = complaints;
}

	public int getEngineerId() {
		return engineerId;
	}

	public void setEngineerId(int engineerId) {
		this.engineerId = engineerId;
	}

	public User getUserEng() {
		return userEng;
	}

	public void setUserEng(User userEng) {
		this.userEng = userEng;
	}

	public String getEngineerName() {
		return engineerName;
	}

	public void setEngineerName(String engineerName) {
		this.engineerName = engineerName;
	}

	public Manager getManagerId() {
		return managerId;
	}

	public void setManagerId(Manager managerId) {
		this.managerId = managerId;
	}

	public List<Complaint> getComplaints() {
		return complaints;
	}

	public void setComplaints(List<Complaint> complaints) {
		this.complaints = complaints;
	}

	@Override
	public String toString() {
		return "Engineer [engineerId=" + engineerId + ", userEng=" + userEng + ", engineerName=" + engineerName
				+ ", managerId=" + managerId + ", complaints=" + complaints + "]";
	}

//	@Override
//	public String toString() {
//		return "Engineer [engineerId=" + engineerId + ", userEng=" + userEng + ", engineerName=" + engineerName
//				+ ", managerId=" + managerId + "]";
//	}
	
	
}
