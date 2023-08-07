import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Ticket } from 'src/app/class/ticket';
import { CustomerService } from 'src/app/service/customer.service';
import { MessageService } from 'src/app/service/message.service';

@Component({
  selector: 'app-new-ticket',
  templateUrl: './new-ticket.component.html',
  styleUrls: ['./new-ticket.component.css']
})
export class NewTicketComponent {
  customerId: number = Number(localStorage.getItem('custId'));
  custPinCode: number = Number(localStorage.getItem('custPinCode'));
  ticket: Ticket = new Ticket();

  constructor(
    private router: Router,
    private customerService: CustomerService,
    private messageService: MessageService
  ) { }



  sendTicket() {
    this.ticket.custPinCode = this.custPinCode;
    // console.info(this.ticket.custPinCode);
    const formData = {
      custName: this.ticket.custName,
      custAddress: this.ticket.custAddress,
      custPinCode: this.ticket.custPinCode,
      problemDesc: this.ticket.problemDesc,
      selectedProblem: this.ticket.selectedProblem,
      custPhoneNo: this.ticket.custPhoneNo
    }

    this.customerService.saveTicket(formData, this.customerId).subscribe(
      (data: any) => {
        console.log(data);
        this.messageService.setMessage(data.message as string)
        this.router.navigate(['/customer-dashboard']);
      },
      (error) => {
        this.messageService.setMessage("Ticket Generation Failed!");
      }
    )
  }





}


