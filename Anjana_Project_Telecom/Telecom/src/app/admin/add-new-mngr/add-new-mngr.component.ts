import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Manager } from 'src/app/class/manager';
import { User } from 'src/app/class/user';
import { AdminService } from 'src/app/service/admin.service';
import { MessageService } from 'src/app/service/message.service';

@Component({
  selector: 'app-add-new-mngr',
  templateUrl: './add-new-mngr.component.html',
  styleUrls: ['./add-new-mngr.component.css']
})
export class AddNewMngrComponent {

  manager: Manager = new Manager();
  user: User = new User();
  timerValue: number = 20;
  timerActive: boolean = false;
  msg: any;

  constructor(
    private messageService: MessageService,
    private adminService: AdminService,
    private router: Router
  ) { }

  // MESSAGE ============
  getMessage(): string {
    return this.messageService.getMessage();
  }

  getMessageClass(): string {
    const message = this.messageService.getMessage();
    return message.toLowerCase().includes('success') ? 'success' : 'failure';
  }
  // ======================

  startTimer() {
    const interval = setInterval(() => {
      this.timerValue -= 1; // Decrement the timer value by 1 second
      if (this.timerValue <= 0) {
        clearInterval(interval); // Stop the timer when it reaches 0
        this.timerActive = false; // Deactivate the timer
      }
    }, 1000); // 1000 milliseconds = 1 second
  }

  // Validate the form fields
  validateForm(): boolean {
    if (
      !this.manager.managerName ||
      !this.user.userUsername ||
      !this.user.userPassword ||
      !this.manager.managerPinCode
    ) {
      console.log("false");
      return false; // Return false if any field is empty
    }
    console.log('true')
    return true; // Return true if all fields are filled
  }

  addNewManager() {
    if (this.validateForm()) {
      const formData = {
        managerName: this.manager.managerName,
        userUsername: this.user.userUsername,
        userPassword: this.user.userPassword,
        managerPinCode: this.manager.managerPinCode
      }
      // console.log(formData);

      this.adminService.addNewManager(formData).subscribe(
        (data) => {
          this.messageService.setMessage("Manager Added Successfully!");

          this.timerActive = true;
          this.startTimer();

          setTimeout(() => {
            this.router.navigate(['/admin-all-mngr']);
          }, 2000);

        },
        (error) => {
          this.messageService.setMessage('A/C Creation FAILED!');
        }
      );

    } else {
      console.log(' validating FALSE');
      this.msg = 'All fields are required!'; // Set validation error message
    }
  }


}
