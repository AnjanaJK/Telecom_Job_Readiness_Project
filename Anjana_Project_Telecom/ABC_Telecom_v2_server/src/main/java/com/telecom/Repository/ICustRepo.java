package com.telecom.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.telecom.DTO.CreateCustRequestDTO;
import com.telecom.DTO.fetchCustDTO;
import com.telecom.Entity.Customer;

public interface ICustRepo extends JpaRepository<Customer, Integer>{

	Customer findByCustomerId(int customerId);

	Customer findByCustomerUsername(String userUsername);

	
	@Query("SELECT c.customerName, c.custPinCode, c.custEmail, c.customerUsername, u.userPassword "
			+ "FROM Customer c "
			+ "JOIN User u "
			+ "ON c.userCust.userId = u.userId "
			+ "WHERE c.customerId = :customerId")
	List<Object[]> findInfo(@Param("customerId") int customerId);

}
