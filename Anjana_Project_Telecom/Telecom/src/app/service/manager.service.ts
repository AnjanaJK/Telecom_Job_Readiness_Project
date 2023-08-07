import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, tap } from 'rxjs';
import { LoginResponse } from '../class/login-response';

@Injectable({
  providedIn: 'root'
})
export class ManagerService {

  private mainUrl = "http://localhost:8090";

  constructor(
    private http: HttpClient
  ) { }

  showEngineers(managerId: number): Observable<any> {
    return this.http.get<any>(`${this.mainUrl}/showEngineers/${managerId}`);
  }

  viewAllTickets(): Observable<any> {
    return this.http.get<any>(`${this.mainUrl}/viewAllTickets`);
  }

  updateComplaintAssigned(ticketId: Number, selectedEngineer: Number): Observable<any> {
    return this.http.put<any>(`${this.mainUrl}/assign/${ticketId}`, selectedEngineer);
  }
}


