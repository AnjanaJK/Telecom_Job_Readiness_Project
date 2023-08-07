import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AdminService } from 'src/app/service/admin.service';
import { MessageService } from 'src/app/service/message.service';

@Component({
  selector: 'app-admin-all-cust',
  templateUrl: './admin-all-cust.component.html',
  styleUrls: ['./admin-all-cust.component.css']
})
export class AdminAllCustComponent {


  data!: any[];


  constructor(
    private adminService: AdminService,
    private messageService: MessageService,
    private router: Router) { }


  ngOnInit(): void {
    this.displayAllCust();
  }

  // MESSAGE ============
  getMessage(): string {
    return this.messageService.getMessage();
  }

  getMessageClass(): string {
    const message = this.messageService.getMessage();
    return message.toLowerCase().includes('success') ? 'success' : 'failure';
  }
  // =====================

  displayAllCust() {
    this.adminService.displayAllCust().subscribe(
      (data) => {
        this.data = data;
      },
      (error) => {
        console.error('Error:', error);
      }
    )
  }

  editCustomer(customerId: number, userId: number): void {
    this.router.navigate(['/edit-cust', customerId, userId]);
  }

  deleteCustomer(customerId: number, userId: number): void {
    this.adminService.deleteCustRecord(customerId, userId).subscribe(
      () => {
        console.log("DELETED");
        this.messageService.setMessage("Record Deleted Successfully!")
      },
      (error) => {
        console.error("ERROR");
        this.messageService.setMessage("Record Deletion Failed!")
      }
    );
  }

}
