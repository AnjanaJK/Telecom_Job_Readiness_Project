package com.telecom.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.telecom.Entity.Engineer;
import com.telecom.Entity.User;

public interface IEngineerRepo extends JpaRepository<Engineer, Integer>{

	@Query("SELECT e.engineerId, e.engineerName "
			+ "FROM Engineer e "
			+ "WHERE e.managerId.managerId = :managerId")
	List<Object[]> findByManagerIdManagerId(@Param("managerId") int managerId);

	Engineer findByEngineerId(int engineerId);

	
	Engineer findByUserEng(User user);

	
	@Query("SELECT t.ticketDate, t.ticketId, t.problemType, t.custName, t.problemDesc, t.status, e.engineerName  "
			+ "FROM Complaint t "
			+ "LEFT JOIN Engineer e "
			+ "ON t.assignedEngineer.engineerId = e.engineerId "
			+ "WHERE t.assignedEngineer.engineerId = :engineerId")
	List<Object[]> findAllTicketsEngineer(@Param("engineerId") int engineerId);

}
