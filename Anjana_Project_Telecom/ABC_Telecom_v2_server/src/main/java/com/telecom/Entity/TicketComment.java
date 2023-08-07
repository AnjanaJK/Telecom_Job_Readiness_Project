package com.telecom.Entity;

import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class TicketComment {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="comment_id")
    private int commentId;

    @ManyToOne
    @JoinColumn(name = "ticket_id")
    @JsonIgnore
    private Complaint ticket;

    @Column(name="comment_text")
    private String commentText;

    @Column(name="comment_date")
    private LocalDateTime commentDate;

    @Column(name="comment_by")
    private String commentBy; // "Customer", "Engineer", or "Manager"

    // Constructors, getters, and setters
    
    public TicketComment() {
		// TODO Auto-generated constructor stub
	}

	public TicketComment(int commentId, Complaint ticket, String commentText, LocalDateTime commentDate,
			String commentBy) {
		super();
		this.commentId = commentId;
		this.ticket = ticket;
		this.commentText = commentText;
		this.commentDate = commentDate;
		this.commentBy = commentBy;
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public Complaint getTicket() {
		return ticket;
	}

	public void setTicket(Complaint ticket) {
		this.ticket = ticket;
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

	@Override
	public String toString() {
		return "TicketComment [commentId=" + commentId + ", ticket=" + ticket + ", commentText=" + commentText
				+ ", commentDate=" + commentDate + ", commentBy=" + commentBy + "]";
	}
	
    
	
	
}
