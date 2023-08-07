import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root'
})
export class EngineerService {

  private mainUrl = "http://localhost:8090";

  constructor(private http: HttpClient) { }

  viewAllTicketsAssignedToMe(engineerId: Number): Observable<any> {
    return this.http.get<any>(`${this.mainUrl}/viewAllTicketsEngineer/${engineerId}`);
  }
}
