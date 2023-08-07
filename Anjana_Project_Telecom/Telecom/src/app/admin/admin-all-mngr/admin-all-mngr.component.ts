import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AdminService } from 'src/app/service/admin.service';
import { MessageService } from 'src/app/service/message.service';

@Component({
  selector: 'app-admin-all-mngr',
  templateUrl: './admin-all-mngr.component.html',
  styleUrls: ['./admin-all-mngr.component.css']
})
export class AdminAllMngrComponent {


  data!: any[];

  constructor(
    private adminService: AdminService,
    private messageService: MessageService,
    private router: Router
  ) { }


  ngOnInit(): void {
    this.displayAllMngr();
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



  displayAllMngr() {
    this.adminService.displayAllMngr().subscribe(
      (data) => {
        this.data = data;
      },
      (error) => {
        console.error('Error:', error);
      }
    )
  }

  editManager(managerId: number, userId: number): void {
    this.router.navigate(['/edit-mngr', managerId, userId]);
  }

  deleteManager(managerId: number, userId: number): void {
    this.adminService.deleteManagerRecord(managerId, userId).subscribe(
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
