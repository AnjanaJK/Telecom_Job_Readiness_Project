package com.telecom.DTO;

import com.telecom.Entity.Customer;
import com.telecom.Entity.Engineer;
import com.telecom.Entity.Manager;
import com.telecom.Entity.User;

public class LoginResponse {
    private User user;
    private Customer customer;
    private Manager manager;
    private Engineer engineer;
//    private int managerId;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Manager getManager() {
		return manager;
	}
	public void setManager(Manager manager) {
		this.manager = manager;
	}
	public Engineer getEngineer() {
		return engineer;
	}
	public void setEngineer(Engineer engineer) {
		this.engineer = engineer;
	}
	
//	public int getManagerId() {
//		return managerId;
//	}
//	public void setManagerId(int managerId) {
//		this.managerId = managerId;
//	}
    
    
}
