import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CustomerService } from 'src/app/service/customer.service';
import { MessageService } from 'src/app/service/message.service';

@Component({
  selector: 'app-resolved-tickets',
  templateUrl: './resolved-tickets.component.html',
  styleUrls: ['./resolved-tickets.component.css']
})
export class ResolvedTicketsComponent implements OnInit {

  custName: string | null = localStorage.getItem('custName');
  data!: [];

  constructor(
    private messageService: MessageService,
    private customerService: CustomerService,
    private router: Router
  ) { }

  ngOnInit() {
    this.displaySolvedTickets();
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


  displaySolvedTickets() {
    const customerId = Number(localStorage.getItem('custId'));
    this.customerService.showSolvedTickets(customerId).subscribe(
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
