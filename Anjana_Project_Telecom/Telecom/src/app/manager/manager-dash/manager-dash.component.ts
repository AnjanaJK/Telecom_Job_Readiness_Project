import { Component, OnInit } from '@angular/core';
import { ManagerService } from 'src/app/service/manager.service';

@Component({
  selector: 'app-manager-dash',
  templateUrl: './manager-dash.component.html',
  styleUrls: ['./manager-dash.component.css']
})

export class ManagerDashComponent implements OnInit {

  name: String = this.capitalizeFirstLetter(String(sessionStorage.getItem('userName')));
  pin: String = String(localStorage.getItem('managerPinCode'));
  data!: any;

  constructor(
    private managerService: ManagerService
  ) { }

  ngOnInit(): void {
    this.showMyEngineers();
  }

  capitalizeFirstLetter(input: string): string {
    if (input.length === 0) {
      return input;
    }

    return input.charAt(0).toUpperCase() + input.slice(1);
  }

  showMyEngineers() {
    const managerId = Number(localStorage.getItem('managerId'));
    this.managerService.showEngineers(managerId).subscribe(
      (data) => {
        console.log(data);
        this.data = data;
      },
      (error) => {
        console.error("ERROR: ", error);
      }
    )
  }
}


