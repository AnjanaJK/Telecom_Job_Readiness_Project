import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AnyCatcher } from 'rxjs/internal/AnyCatcher';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  private mainUrl = "http://localhost:8090";

  constructor(private http: HttpClient) { }

  saveTicket(formData: any, customerId: number): Observable<any> {
    // console.log("custId: ", customerId)
    return this.http.post(`${this.mainUrl}/createTicket/${customerId}`, formData);
  }

  showRaisedTickets(customerId: number): Observable<any> {
    return this.http.get<any>(`${this.mainUrl}/showRaised/${customerId}`);
  }

  showSolvedTickets(customerId: number): Observable<any> {
    return this.http.get<any>(`${this.mainUrl}/showSolved/${customerId}`);
  }

  displayProfile(customerId: number): Observable<any> {
    return this.http.get<any>(`${this.mainUrl}/showProfileInfo/${customerId}`);
  }

  changePassword(oldPassword: String, newPassword: String, userId: number): Observable<any> {
    const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    const body = { oldPassword, newPassword };
    return this.http.put(`${this.mainUrl}/changePassword/${userId}`, body, { headers });
  }
}
