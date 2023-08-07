package com.telecom.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.telecom.Entity.Complaint;

@Repository
public interface IComplaintRepo extends JpaRepository<Complaint, Integer> {

	@Query("SELECT c.ticketDate, c.ticketId, c.problemType, c.problemDesc, c.status "
			+ "FROM Complaint c "
			+ "WHERE c.custComplaint.customerId = :customerId "
			+ "AND (c.status = 'RAISED' OR c.status = 'ESCALATED' OR c.status = 'WIP') ")
	List<Object[]> findByCustComplaintCustomerId(@Param("customerId") int customerId);
	
	
	@Query("SELECT c.ticketDate, c.ticketId, c.problemType, c.problemDesc, c.status "
			+ "FROM Complaint c "
			+ "WHERE c.custComplaint.customerId = :customerId "
			+ "AND c.status = 'RESOLVED'")
	List<Object[]> solvedTickets(@Param("customerId") int customerId);


	Complaint findByTicketId(int ticketId);

}
