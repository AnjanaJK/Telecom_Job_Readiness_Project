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
public class Manager {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "manager_id")
    private int managerId;
	
	@Column(name="pin_code")
	private long pinCode;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User userMngr;
	
	@Column(name="manager_name")
	private String managerName;
	
	@OneToMany(mappedBy = "managerId")
	@JsonIgnore
    private List<Engineer> engineers;
	
//	------------------------------------------------------------
	
	public Manager() {
		// TODO Auto-generated constructor stub
	}

	public Manager(int managerId, long pinCode, User userMngr, String managerName, List<Engineer> engineers) {
		super();
		this.managerId = managerId;
		this.pinCode = pinCode;
		this.userMngr = userMngr;
		this.managerName = managerName;
		this.engineers = engineers;
	}
	
	public int getManagerId() {
		return managerId;
	}
	
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	
	public long getPinCode() {
		return pinCode;
	}
	
	public void setPinCode(long pinCode) {
		this.pinCode = pinCode;
	}
	
	public User getUserMngr() {
		return userMngr;
	}
	
	public void setUserMngr(User userMngr) {
		this.userMngr = userMngr;
	}
	
	public String getManagerName() {
		return managerName;
	}
	
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	
	public List<Engineer> getEngineers() {
		return engineers;
	}
	
	public void setEngineers(List<Engineer> engineers) {
		this.engineers = engineers;
	}
	
	@Override
	public String toString() {
		return "Manager [managerId=" + managerId + ", pinCode=" + pinCode + ", userMngr=" + userMngr + ", managerName="
				+ managerName + ", engineers=" + engineers + "]";
	}
	
}
