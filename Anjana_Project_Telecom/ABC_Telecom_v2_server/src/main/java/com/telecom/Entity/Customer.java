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
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cust_id")
	private int customerId;
	
	@Column(name="cust_username")
	private String customerUsername;
	
	@Column(name="cust_name")
	private String customerName;
	
	@ManyToOne
	@JoinColumn(name="user_id")
//	@JsonIgnore
	private User userCust;
	
	@Column(name="pin_code")
	private long custPinCode;
	
	@Column(name="cust_email")
	private String custEmail;
	
	@OneToMany(mappedBy = "custComplaint")
    private List<Complaint> complaints;
	
//	--------------------------------------------------------
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(int customerId, String customerUsername, String customerName, User userCust, long custPinCode,
		String custEmail, List<Complaint> complaints) {
		super();
		this.customerId = customerId;
		this.customerUsername = customerUsername;
		this.customerName = customerName;
		this.userCust = userCust;
		this.custPinCode = custPinCode;
		this.custEmail = custEmail;
		this.complaints = complaints;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerUsername() {
		return customerUsername;
	}

	public void setCustomerUsername(String customerUsername) {
		this.customerUsername = customerUsername;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	public User getUserCust() {
		return userCust;
	}

	public void setUserCust(User userCust) {
		this.userCust = userCust;
	}

	public long getCustPinCode() {
		return custPinCode;
	}

	public void setCustPinCode(long custPinCode) {
		this.custPinCode = custPinCode;
	}

	public List<Complaint> getComplaints() {
		return complaints;
	}

	public void setComplaints(List<Complaint> complaints) {
		this.complaints = complaints;
	}

    @Override
    public String toString() {
        return "Customer{" +
                "custId=" + customerId +
                ", pincode=" + custPinCode +
                ", custName='" + customerName + '\'' +
                ", custUsername='" + customerUsername + '\'' +
                ", custEmail='" + custEmail + '\'' +
                // Avoid including the collections in the toString() representation
                // ", complaints=" + complaints +
                // ", user=" + user +
                '}';
    }


	
}
