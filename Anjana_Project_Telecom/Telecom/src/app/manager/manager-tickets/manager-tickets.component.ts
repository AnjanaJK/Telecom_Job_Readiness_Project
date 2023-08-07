import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ManagerService } from 'src/app/service/manager.service';

@Component({
  selector: 'app-manager-tickets',
  templateUrl: './manager-tickets.component.html',
  styleUrls: ['./manager-tickets.component.css']
})
export class ManagerTicketsComponent implements OnInit {
  capitalizeFirstLetter(input: string): string {
    if (input.length === 0) {
      return input;
    }

    return input.charAt(0).toUpperCase() + input.slice(1);
  }


  name: String = this.capitalizeFirstLetter(String(sessionStorage.getItem('userName')));
  pin: String = String(localStorage.getItem('managerPinCode'));
  data!: [];
  engineers: any[] = [];
  selectedEngineer: number | null = null; // To store the selected engineer ID


  constructor(
    private managerService: ManagerService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.viewAllTickets();
    this.showMyEngineers();
  }

  viewAllTickets() {
    this.managerService.viewAllTickets().subscribe(
      (data) => {
        this.data = data;
      },
      (error) => {
        console.error("ERROR: ", error);
      }
    )
  }

  showMyEngineers() {
    const managerId = Number(localStorage.getItem('managerId'));
    this.managerService.showEngineers(managerId).subscribe(
      (data: any[]) => {
        console.log(data);
        this.engineers = data;
      },
      (error) => {
        console.error("ERROR: ", error);
      }
    )
  }

  onStatusChange(ticketId: number, selectedEngineerId: string) {
    this.selectedEngineer = Number(selectedEngineerId); // Convert to number using Number()
    console.info(this.selectedEngineer);
    console.info(ticketId);

    // Update the "assigned" column in the backend
    this.managerService.updateComplaintAssigned(ticketId, this.selectedEngineer).subscribe(
      (response) => {
        console.log('Complaint assigned successfully');
        console.log(response);
        // Refresh the page after the update
        window.location.reload();
      },
      (error: any) => {
        console.log('Error assigning complaint:', error);
      }
    );
  }

  viewTicket(ticketId: number): void {
    this.router.navigate(['/view-ticket', ticketId]);
  }


}
