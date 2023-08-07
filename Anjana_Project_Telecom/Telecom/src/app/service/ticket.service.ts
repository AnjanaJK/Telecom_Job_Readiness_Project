import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Ticket } from '../class/ticket';
import { TicketComment } from '../class/ticket-comment';

@Injectable({
  providedIn: 'root'
})
export class TicketService {
  private mainUrl = "http://localhost:8090";

  constructor(
    private http: HttpClient
  ) { }

  getTicketById(ticketId: Number): Observable<Ticket> {
    return this.http.get<Ticket>(`${this.mainUrl}/viewComplaints/${ticketId}`);
  }

  addTicketComment(newComment: TicketComment): Observable<TicketComment> {
    return this.http.post<TicketComment>(`${this.mainUrl}/addComment`, newComment);
  }

  getTicketComments(ticketId: number): Observable<any> {
    return this.http.get<any>(`${this.mainUrl}/getCommentComments/${ticketId}`);
  }

  updateTicketStatus(ticketId: number, status: string): Observable<any> {
    return this.http.put<any>(`${this.mainUrl}/updateTicketStatus/${ticketId}/${status}`, status);
  }
}
