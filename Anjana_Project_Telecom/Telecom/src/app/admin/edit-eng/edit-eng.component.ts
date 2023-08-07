import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Engineer } from 'src/app/class/engineer';
import { Manager } from 'src/app/class/manager';
import { User } from 'src/app/class/user';
import { AdminService } from 'src/app/service/admin.service';
import { MessageService } from 'src/app/service/message.service';

@Component({
  selector: 'app-edit-eng',
  templateUrl: './edit-eng.component.html',
  styleUrls: ['./edit-eng.component.css']
})
export class EditEngComponent implements OnInit {
  engineer: Engineer = new Engineer();
  user: User = new User();
  engineerId!: number;
  userId!: number;
  managers: Manager[] = [];

  constructor(
    private route: ActivatedRoute,
    private adminService: AdminService,
    private messageService: MessageService,
    private router: Router
  ) { }

  ngOnInit(): void {
    // Extract the engineerId from the URL
    this.route.paramMap.subscribe(params => {
      this.engineerId = +params.get('eid')!; // Use nullish coalescing operator to handle null or undefined
      this.userId = +params.get('uid')!
    });

    // Fetch the customer data based on the engineerId if it is not null
    if (this.engineerId !== null) {
      this.fetchEngineerData();
      this.fetchManagers();
    }
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


  fetchEngineerData() {
    this.adminService.getEngineerById(this.engineerId, this.userId).subscribe(
      (data: any) => {
        console.warn(data);
        this.engineer = data;
        this.user = data;
      },
      (error) => {
        console.error('Error fetching Engineer data:', error);
      }
    );
  }

  onUpdateClick() {
    const formData = {
      engineerName: this.engineer.engineerName,
      userUsername: this.user.userUsername,
      userPassword: this.user.userPassword,
      selectedManager: this.engineer.selectedManager
    }

    this.adminService.updateEngineerRecord(formData, this.engineerId, this.userId).subscribe(
      () => {
        console.log('Engineer details updated successfully!');
        this.messageService.setMessage('Engineer details updated successfully!');
        this.router.navigate(['/admin-all-eng']);

      },
      (error) => {
        console.error('Failed to update Engineer details:', error);
        this.messageService.setMessage('Failed to update Engineer details!');
      }
    );
  }

}
