package com.telecom.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telecom.Entity.User;
import com.telecom.Repository.IUserRepo;

@Service
public class UserService {
	@Autowired
	private IUserRepo userRepo;

	public User findUser(String userUsername, String userPassword) {
		return userRepo.findByUserUsernameAndUserPassword(userUsername, userPassword);
	}

	public List<Object[]> getAllCustData() {
		return userRepo.getAllCustData();
	}

	public List<Object[]> getAllEngData() {
		return userRepo.getAllEngData();
	}

	public List<Object[]> getAllMngrData() {
		return userRepo.getAllMngrData();
	}
	
	
}
