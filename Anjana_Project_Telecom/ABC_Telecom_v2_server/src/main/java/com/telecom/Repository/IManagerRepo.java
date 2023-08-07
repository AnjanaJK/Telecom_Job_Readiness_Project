package com.telecom.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.telecom.Entity.Manager;
import com.telecom.Entity.User;

public interface IManagerRepo extends JpaRepository<Manager, Integer>{

	Manager findByManagerName(String userUsername);

	Manager findByUserMngr(User user);

	@Query("SELECT t.ticketId, t.custName, t.pinCode, t.problemType, t.ticketDate, e.engineerName, t.status "
			+ "FROM Complaint t "
			+ "LEFT JOIN Engineer e "
			+ "ON t.assignedEngineer.engineerId = e.engineerId")
	List<Object[]> findAllTickets();

	Manager findByManagerId(int managerId);

}
