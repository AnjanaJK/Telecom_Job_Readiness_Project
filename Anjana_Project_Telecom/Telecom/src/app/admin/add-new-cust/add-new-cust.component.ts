import { Component } from '@angular/core';
import { Location } from '@angular/common';
import { Cust } from 'src/app/class/cust';
import { AdminService } from 'src/app/service/admin.service';
import { User } from 'src/app/class/user';
import { Router } from '@angular/router';
import { MessageService } from 'src/app/service/message.service';

@Component({
  selector: 'app-add-new-cust',
  templateUrl: './add-new-cust.component.html',
  styleUrls: ['./add-new-cust.component.css']
})
export class AddNewCustComponent {

  cust: Cust = new Cust();
  user: User = new User();
  timerValue: number = 20;
  timerActive: boolean = false;
  msg: any;


  constructor(
    private location: Location,
    private adminService: AdminService,
    private router: Router,
    private messageService: MessageService
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
      !this.cust.custName ||
      !this.cust.custEmail ||
      !this.user.userUsername ||
      !this.user.userPassword ||
      !this.cust.custPinCode
    ) {
      console.log("false");
      return false; // Return false if any field is empty
    }
    console.log('true')
    return true; // Return true if all fields are filled
  }

  onCancelClick() {
    // Call the back() method to navigate back to the previous page
    this.location.back();
  }

  addNewCust() {
    if (this.validateForm()) {
      const formData = {
        custName: this.cust.custName,
        custEmail: this.cust.custEmail,
        userUsername: this.user.userUsername,
        userPassword: this.user.userPassword,
        custPinCode: this.cust.custPinCode
      }

      console.log(formData);

      this.adminService.addNewCust(formData).subscribe(
        (data) => {
          this.messageService.setMessage("Customer Added Successfully!");

          this.timerActive = true;
          this.startTimer();

          setTimeout(() => {
            this.router.navigate(['/admin-all-cust']);
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
