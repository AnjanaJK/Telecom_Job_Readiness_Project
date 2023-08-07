import { Component, OnInit } from '@angular/core';
import { Ticket } from '../class/ticket';
import { ActivatedRoute } from '@angular/router';
import { TicketService } from '../service/ticket.service';
import { TicketComment } from '../class/ticket-comment';

@Component({
  selector: 'app-view-ticket',
  templateUrl: './view-ticket.component.html',
  styleUrls: ['./view-ticket.component.css']
})
export class ViewTicketComponent implements OnInit {
  ticketId!: number;
  ticket: Ticket = new Ticket();
  custPinCode!: number;
  newCommentText: string = '';
  comments: TicketComment[] = [];
  custName = String(sessionStorage.getItem('userName'));
  userId = String(sessionStorage.getItem('userId'));
  userRole = String(sessionStorage.getItem('userRole'));
  ticketStatus!: String;
  feedback: string = '';

  constructor(
    private route: ActivatedRoute,
    private ticketService: TicketService
  ) { }

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      this.ticketId = +params.get('tid')!; // Use nullish coalescing operator to handle null or undefined

    });

    this.loadTicketDetails();
    this.fetchTicketComments();
  }

  loadTicketDetails() {
    this.ticketService.getTicketById(this.ticketId).subscribe(
      (ticket: Ticket) => {
        this.ticket = ticket;
        console.info(ticket)
      },
      (error) => {
        console.error('Error loading ticket details:', error);
      }
    );
  }

  addComment() {
    const userName = String(sessionStorage.getItem('userName'));
    const newComment: TicketComment = {
      // commentId: null, // The ID will be assigned by the backend upon creation
      ticketId: this.ticketId, // Set the ticket associated with this comment
      commentText: this.newCommentText,
      commentDate: new Date(),
      commentBy: userName
    };

    // console.log(newComment);
    this.ticketService.addTicketComment(newComment).subscribe(
      (addedComment: TicketComment) => {
        this.comments.push(addedComment); // Add the new comment to the comments list
        window.location.reload();
      },
      (error) => {
        console.error('Error adding comment:', error);
      }
    );


  }

  fetchTicketComments(): void {
    this.ticketService.getTicketComments(this.ticketId).subscribe(
      (comments: TicketComment[]) => {
        this.comments = comments.map(comment => ({
          ...comment,
          commentDate: new Date(comment.commentDate)
        })).sort((a, b) => b.commentDate.getTime() - a.commentDate.getTime());
        // console.info(comments)
      },
      error => {
        console.error('Error fetching ticket comments:', error);
      }
    );
  }


  markResolved(): void {
    this.ticketService.updateTicketStatus(this.ticketId, 'RESOLVED').subscribe(
      () => {
        // Success message or any further actions after successful update
        this.ticketStatus = 'RESOLVED';
      },
      (error) => {
        console.error('Error marking ticket as resolved:', error);
      }
    );
  }

  markEscalated(): void {
    this.ticketService.updateTicketStatus(this.ticketId, 'ESCALATED').subscribe(
      () => {
        // Success message or any further actions after successful update
        this.ticketStatus = 'ESCALATED';
      },
      (error) => {
        console.error('Error marking ticket as escalated:', error);
      }
    );
  }

}
