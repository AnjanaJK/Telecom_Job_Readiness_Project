import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Engineer } from 'src/app/class/engineer';
import { Manager } from 'src/app/class/manager';
import { User } from 'src/app/class/user';
import { AdminService } from 'src/app/service/admin.service';
import { MessageService } from 'src/app/service/message.service';

@Component({
  selector: 'app-add-new-eng',
  templateUrl: './add-new-eng.component.html',
  styleUrls: ['./add-new-eng.component.css']
})
export class AddNewEngComponent implements OnInit {

  engineer: Engineer = new Engineer();
  user: User = new User();
  managers: Manager[] = [];
  timerValue: number = 20;
  timerActive: boolean = false;
  msg: any;

  constructor(
    private messageService: MessageService,
    private adminService: AdminService,
    private router: Router
  ) { }

  ngOnInit() {
    this.fetchManagers();
  }

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


  fetchManagers() {
    this.adminService.getManagers().subscribe(
      (managers) => {
        this.managers = managers;
        console.log(managers);
      },
      (error) => {
        console.error('Error fetching managers:', error);
      }
    );
  }

  // Validate the form fields
  validateForm(): boolean {
    if (
      !this.engineer.engineerName ||
      !this.user.userUsername ||
      !this.user.userPassword ||
      !this.engineer.selectedManager
    ) {
      console.log("false");
      return false; // Return false if any field is empty
    }
    console.log('true')
    return true; // Return true if all fields are filled
  }

  addNewEngineer() {
    if (this.validateForm()) {
      const formData = {
        engineerName: this.engineer.engineerName,
        userUsername: this.user.userUsername,
        userPassword: this.user.userPassword,
        selectedManager: this.engineer.selectedManager
      }
      // console.log(formData);

      this.adminService.addNewEngineer(formData).subscribe(
        (data) => {
          this.messageService.setMessage("Engineer Added Successfully!");

          this.timerActive = true;
          this.startTimer();

          setTimeout(() => {
            this.router.navigate(['/admin-all-eng']);
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
