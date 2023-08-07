package com.telecom.DTO;

import java.sql.Date;
import java.time.LocalDateTime;

public class TicketCommentDTO {
    private int ticketId;
    private String commentText;
    private LocalDateTime commentDate;
    private String commentBy;
    
	public int getTicketId() {
		return ticketId;
	}
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
	public String getCommentText() {
		return commentText;
	}
	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}
	public LocalDateTime getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(LocalDateTime commentDate) {
		this.commentDate = commentDate;
	}
	public String getCommentBy() {
		return commentBy;
	}
	public void setCommentBy(String commentBy) {
		this.commentBy = commentBy;
	}

    // Constructors, getters, setters, etc.
    
}