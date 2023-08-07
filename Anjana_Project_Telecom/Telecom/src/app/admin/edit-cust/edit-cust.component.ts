import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Cust } from 'src/app/class/cust';
import { User } from 'src/app/class/user';
import { AdminService } from 'src/app/service/admin.service';
import { Location } from '@angular/common';
import { MessageService } from 'src/app/service/message.service';

@Component({
  selector: 'app-edit-cust',
  templateUrl: './edit-cust.component.html',
  styleUrls: ['./edit-cust.component.css']
})
export class EditCustComponent implements OnInit {

  customerId!: number;
  userId!: number;
  cust: Cust = new Cust();
  user: User = new User;

  constructor(
    private route: ActivatedRoute,
    private adminService: AdminService,
    private location: Location,
    private messageService: MessageService,
    private router: Router
  ) { }

  ngOnInit(): void {
    // Extract the customerId from the URL
    this.route.paramMap.subscribe(params => {
      this.customerId = +params.get('cid')!; // Use nullish coalescing operator to handle null or undefined
      this.userId = +params.get('uid')!
    });

    // Fetch the customer data based on the customerId if it is not null
    if (this.customerId !== null) {
      this.fetchCustomerData();
    }
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

  onCancelClick() {
    // Call the back() method to navigate back to the previous page
    this.location.back();
  }

  fetchCustomerData(): void {
    this.adminService.getCustomerById(this.customerId, this.userId).subscribe(
      (data: any) => {
        console.warn(data);
        this.cust = data;
        this.user = data;
      },
      (error) => {
        console.error('Error fetching customer data:', error);
      }
    );
  }

  onUpdateClick() {
    const formData = {
      custName: this.cust.custName,
      custEmail: this.cust.custEmail,
      userUsername: this.user.userUsername,
      custPinCode: this.cust.custPinCode
    }

    // console.error(formData)
    this.adminService.updateCustomerRecord(formData, this.customerId, this.userId).subscribe(
      () => {
        console.log('Customer details updated successfully!');
        this.messageService.setMessage('Customer details updated successfully!');
        this.router.navigate(['/admin-all-cust']);

      },
      (error) => {
        console.error('Failed to update customer details:', error);
        this.messageService.setMessage('Failed to update customer details!');
      }
    );
  }
}
