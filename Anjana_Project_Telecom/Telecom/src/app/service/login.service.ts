import { Injectable } from '@angular/core';
import { User } from '../class/user';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { LoginResponse } from '../class/login-response';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private mainUrl = "http://localhost:8090";

  constructor(private http: HttpClient) { }

  // MESSAGE ==============================
  public setSessionData(data: any): void {
    sessionStorage.setItem('userId', data.user.userId);
    sessionStorage.setItem('userName', data.user.userUsername);
    sessionStorage.setItem('userRole', data.user.userRole);
    // localStorage.setItem('custName', data.customer.customerName)
  }

  public clearSessionData(): void {
    sessionStorage.removeItem('userId');
    sessionStorage.removeItem('userName');
    sessionStorage.removeItem('userRole');
  }
  // =========================================

  doLogin(user: any): Observable<LoginResponse> {
    console.log(user);
    return this.http.post<LoginResponse>(`${this.mainUrl}/login`, user);
  }
}
