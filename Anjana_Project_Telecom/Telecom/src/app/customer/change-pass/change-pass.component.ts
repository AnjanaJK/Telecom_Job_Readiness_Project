import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/class/user';
import { CustomerService } from 'src/app/service/customer.service';
import { LoginService } from 'src/app/service/login.service';
import { MessageService } from 'src/app/service/message.service';

@Component({
  selector: 'app-change-pass',
  templateUrl: './change-pass.component.html',
  styleUrls: ['./change-pass.component.css']
})
export class ChangePassComponent {

  user: User = new User();
  userId: number = Number(sessionStorage.getItem('userId'));
  // oldPassword!: string;
  // newPassword!: string;
  error!: string;

  constructor(
    private customerService: CustomerService,
    private messageService: MessageService,
    private router: Router,
    private loginService: LoginService
  ) { }

  changePassword() {
    this.customerService.changePassword(this.user.userPassword, this.user.newPassword, this.userId)
      .subscribe(
        () => {

          setTimeout(() => {

            this.loginService.clearSessionData();
            localStorage.removeItem('custName');
            localStorage.removeItem('custId');
            localStorage.removeItem('custPinCode');
            this.messageService.setMessage('Password changed successfully. Please log in again with your new password.');
            window.location.replace("/");
            // location.reload();
          }, 2000);

        },
        error => {
          this.messageService.setMessage('Password Change FAILED!');
        }
      );
  }
}
