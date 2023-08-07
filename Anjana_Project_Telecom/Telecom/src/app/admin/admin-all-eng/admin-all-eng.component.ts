import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AdminService } from 'src/app/service/admin.service';
import { MessageService } from 'src/app/service/message.service';

@Component({
  selector: 'app-admin-all-eng',
  templateUrl: './admin-all-eng.component.html',
  styleUrls: ['./admin-all-eng.component.css']
})
export class AdminAllEngComponent {

  data!: any[];

  constructor(
    private adminService: AdminService,
    private messageService: MessageService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.displayAllEng();
  }

  // MESSAGE ============
  getMessage(): string {
    return this.messageService.getMessage();
  }

  getMessageClass(): string {
    const message = this.messageService.getMessage();
    return message.toLowerCase().includes('success') ? 'success' : 'failure';
  }
  // ========================



  displayAllEng() {
    this.adminService.displayAllEng().subscribe(
      (data) => {
        this.data = data;
      },
      (error) => {
        console.error('Error:', error);
      }
    )
  }

  editEngineer(engineerId: number, userId: number): void {
    this.router.navigate(['/edit-eng', engineerId, userId]);
  }

  deleteEngineer(engineerId: number, userId: number): void {
    this.adminService.deleteEngineerRecord(engineerId, userId).subscribe(
      () => {
        console.log("DELETED");
        this.messageService.setMessage("Record Deleted Successfully!")
        window.location.reload();
      },
      (error) => {
        console.error("ERROR");
        this.messageService.setMessage("Record Deletion Failed!")
      }
    );
  }

}
