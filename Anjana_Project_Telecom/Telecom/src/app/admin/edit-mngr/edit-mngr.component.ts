import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Manager } from 'src/app/class/manager';
import { User } from 'src/app/class/user';
import { AdminService } from 'src/app/service/admin.service';
import { MessageService } from 'src/app/service/message.service';

@Component({
  selector: 'app-edit-mngr',
  templateUrl: './edit-mngr.component.html',
  styleUrls: ['./edit-mngr.component.css']
})
export class EditMngrComponent implements OnInit {
  manager: Manager = new Manager();
  user: User = new User();
  managerId!: number;
  userId!: number;

  constructor(
    private route: ActivatedRoute,
    private adminService: AdminService,
    private messageService: MessageService,
    private router: Router
  ) { }

  ngOnInit(): void {
    // Extract the managerId from the URL
    this.route.paramMap.subscribe(params => {
      this.managerId = +params.get('mid')!; // Use nullish coalescing operator to handle null or undefined
      this.userId = +params.get('uid')!
    });

    // Fetch the customer data based on the managerId if it is not null
    if (this.managerId !== null) {
      this.fetchManagerData();
    }
  }

  fetchManagerData(): void {
    this.adminService.getManagerById(this.managerId, this.userId).subscribe(
      (data: any) => {
        console.warn(data);
        this.manager = data;
        this.user = data;
      },
      (error) => {
        console.error('Error fetching customer data:', error);
      }
    );
  }

  onUpdateClick() {
    const formData = {
      managerName: this.manager.managerName,
      userUsername: this.user.userUsername,
      managerPinCode: this.manager.managerPinCode
    }

    this.adminService.updateManagerRecord(formData, this.managerId, this.userId).subscribe(
      () => {
        console.log('Manager details updated successfully!');
        this.messageService.setMessage('Manager details updated successfully!');
        this.router.navigate(['/admin-all-mngr']);

      },
      (error) => {
        console.error('Failed to update Manager details:', error);
        this.messageService.setMessage('Failed to update Manager details!');
      }
    );
  }

}
