import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { EngineerService } from 'src/app/service/engineer.service';

@Component({
  selector: 'app-engineer-dash',
  templateUrl: './engineer-dash.component.html',
  styleUrls: ['./engineer-dash.component.css']
})
export class EngineerDashComponent {
  data!: [];
  engineerName: String = this.capitalizeFirstLetter(String(sessionStorage.getItem('userName')));

  constructor(
    private router: Router,
    private engineerService: EngineerService
  ) { }

  capitalizeFirstLetter(input: string): string {
    if (input.length === 0) {
      return input;
    }

    return input.charAt(0).toUpperCase() + input.slice(1);
  }
  ngOnInit(): void {
    this.viewAllTicketsAssignedToMe();
  }

  viewAllTicketsAssignedToMe() {
    const engineerId = Number(localStorage.getItem('engineerId'));
    this.engineerService.viewAllTicketsAssignedToMe(engineerId).subscribe(
      (data) => {
        this.data = data;
      },
      (error) => {
        console.error("ERROR: ", error);
      }
    )
  }

  viewTicket(ticketId: number): void {
    this.router.navigate(['/view-ticket', ticketId]);
  }
}
