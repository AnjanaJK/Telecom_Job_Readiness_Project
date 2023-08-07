import { Component } from '@angular/core';
import { LoginService } from '../service/login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {
  userId!: string | null;
  userName!: string | null;
  userRole!: string | null;
  // firstName!: string | null;
  // lastName!: string | null;
  custName!: string | null;

  constructor(
    private loginService: LoginService,
    private router: Router
  ) {
    // Fetch the userRole from the sessionStorage (or wherever you store it)
    this.userId = sessionStorage.getItem('userId');
    this.userName = sessionStorage.getItem('userName');
    this.userRole = sessionStorage.getItem('userRole');
    // this.firstName = localStorage.getItem('FirstName');
    // this.lastName = localStorage.getItem('LastName');
    this.custName = localStorage.getItem('custName');
  }

  showAdminUrl(): boolean {
    // Check if the userRole is 'Admin' and the current URL is not '/admin-dashboard'
    return this.userRole === 'Admin' && this.router.url !== '/admin-dashboard';
  }

  logout() {
    // Clear the user session data from sessionStorage
    this.loginService.clearSessionData();
    localStorage.removeItem('custName');
    localStorage.removeItem('custId');
    localStorage.removeItem('custPinCode');
    localStorage.removeItem('managerId');
    localStorage.removeItem('managerPinCode');
    localStorage.removeItem('engineerId');
    // this.userService.clearSessionData();
    window.location.href = '/';
  }
}
