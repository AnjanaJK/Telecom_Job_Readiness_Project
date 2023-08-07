import { Component, OnInit, numberAttribute } from '@angular/core';
import { CustomerService } from 'src/app/service/customer.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  customerId: number = Number(localStorage.getItem("custId"));
  data!: [];


  constructor(
    private customerService: CustomerService
  ) { }

  ngOnInit(): void {
    this.displayProfile();
  }


  displayProfile() {
    this.customerService.displayProfile(this.customerId).subscribe(
      (data) => {
        console.log(this.customerId)
        this.data = data;
      },
      (error) => {
        console.error("ERROR: ", error);
      }
    )
  }
}
