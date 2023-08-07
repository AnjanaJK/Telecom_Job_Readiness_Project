package com.telecom.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telecom.Entity.TicketComment;

@Repository
public interface ICommentRepo extends JpaRepository<TicketComment, Integer>{

	List<TicketComment> findByTicketTicketId(int ticketId);

}
