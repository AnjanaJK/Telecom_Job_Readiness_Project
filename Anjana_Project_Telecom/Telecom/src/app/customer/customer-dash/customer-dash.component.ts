import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CustomerService } from 'src/app/service/customer.service';
import { MessageService } from 'src/app/service/message.service';

@Component({
  selector: 'app-customer-dash',
  templateUrl: './customer-dash.component.html',
  styleUrls: ['./customer-dash.component.css']
})
export class CustomerDashComponent implements OnInit {

  custName: string | null = localStorage.getItem('custName');
  data!: [];

  constructor(
    private messageService: MessageService,
    private customerService: CustomerService,
    private router: Router
  ) { }

  ngOnInit() {
    this.displayRaisedTickets();
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


  displayRaisedTickets() {
    const customerId = Number(localStorage.getItem('custId'));
    this.customerService.showRaisedTickets(customerId).subscribe(
      (data: any) => {
        // console.log(data);
        this.data = data;
        // this.messageService.setMessage(data.message as string)
        // this.router.navigate(['/customer-dashboard']);
      },
      (error) => {
        this.messageService.setMessage("ERROR: Failed to load tickets!");
      }
    )
  }


  viewTicket(ticketId: number): void {
    this.router.navigate(['/view-ticket', ticketId]);
  }
}
