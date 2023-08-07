import { Component, OnInit } from '@angular/core';
import { User } from '../class/user';
import { LoginService } from '../service/login.service';
import { MessageService } from '../service/message.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  // Creating obj of User class (user.ts)
  user: User = new User();


  constructor(
    private loginService: LoginService,
    private messageService: MessageService
  ) { }


  ngOnInit() {

  }

  // MESSAGE ============
  getMessage(): string {
    return this.messageService.getMessage();
  }

  getMessageClass(): string {
    const message = this.messageService.getMessage();
    return message.toLowerCase().includes('success') ? 'success' : 'failure';
  }
  // ========================

  userLogin() {
    // console.warn(this.user);

    // call the service
    this.loginService.doLogin(this.user).subscribe(
      (data: any) => {
        console.log(data);
        // Save the user ID in sessionStorage
        this.loginService.setSessionData(data);
        if (data.customer != null) {
          localStorage.setItem('custName', data.customer.customerName);
          localStorage.setItem('custId', data.customer.customerId);
          localStorage.setItem('custPinCode', data.customer.custPinCode);
        }

        if (data.user.userRole === "Admin") {
          window.location.href = '/admin-dashboard';
        }
        else if (data.user.userRole === "Manager") {
          localStorage.setItem('managerId', data.manager.managerId);
          localStorage.setItem('managerPinCode', data.manager.pinCode);
          window.location.href = '/manager-dashboard';
        }
        else if (data.user.userRole === "Engineer") {
          localStorage.setItem('engineerId', data.engineer.engineerId);
          window.location.href = '/engineer-dashboard';
        }
        else {
          window.location.href = '/customer-dashboard';
        }

        this.messageService.setMessage('Login Success!');
      },
      (error) => {
        this.messageService.setMessage('Login Failed. Please try again.');
      }
    );
  }
}
