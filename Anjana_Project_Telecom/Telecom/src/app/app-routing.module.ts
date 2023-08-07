import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { AdminDashComponent } from './admin/admin-dash/admin-dash.component';
import { CustomerDashComponent } from './customer/customer-dash/customer-dash.component';
import { ManagerDashComponent } from './manager/manager-dash/manager-dash.component';
import { EngineerDashComponent } from './engineer/engineer-dash/engineer-dash.component';
import { AdminAllCustComponent } from './admin/admin-all-cust/admin-all-cust.component';
import { AdminAllEngComponent } from './admin/admin-all-eng/admin-all-eng.component';
import { AdminAllMngrComponent } from './admin/admin-all-mngr/admin-all-mngr.component';
import { AddNewCustComponent } from './admin/add-new-cust/add-new-cust.component';
import { EditCustComponent } from './admin/edit-cust/edit-cust.component';
import { NewTicketComponent } from './customer/new-ticket/new-ticket.component';
import { ResolvedTicketsComponent } from './customer/resolved-tickets/resolved-tickets.component';
import { ProfileComponent } from './customer/profile/profile.component';
import { ChangePassComponent } from './customer/change-pass/change-pass.component';
import { ManagerTicketsComponent } from './manager/manager-tickets/manager-tickets.component';
import { ViewTicketComponent } from './view-ticket/view-ticket.component';
import { AddNewMngrComponent } from './admin/add-new-mngr/add-new-mngr.component';
import { EditMngrComponent } from './admin/edit-mngr/edit-mngr.component';
import { AddNewEngComponent } from './admin/add-new-eng/add-new-eng.component';
import { EditEngComponent } from './admin/edit-eng/edit-eng.component';

const routes: Routes = [
  { path: "", redirectTo: "home", pathMatch: "full" },
  { path: "home", component: LoginComponent },
  { path: "admin-dashboard", component: AdminDashComponent },

  { path: "admin-all-cust", component: AdminAllCustComponent },
  { path: "add-new-cust", component: AddNewCustComponent },
  { path: "edit-cust/:cid/:uid", component: EditCustComponent },

  { path: "admin-all-eng", component: AdminAllEngComponent },
  { path: "add-new-eng", component: AddNewEngComponent },
  { path: "edit-eng/:eid/:uid", component: EditEngComponent },

  { path: "admin-all-mngr", component: AdminAllMngrComponent },
  { path: "add-new-mngr", component: AddNewMngrComponent },
  { path: "edit-mngr/:mid/:uid", component: EditMngrComponent },

  { path: "customer-dashboard", component: CustomerDashComponent },
  { path: "new-ticket", component: NewTicketComponent },
  { path: "resolved-tickets", component: ResolvedTicketsComponent },
  { path: "profile", component: ProfileComponent },
  { path: "change-pass", component: ChangePassComponent },

  { path: "manager-dashboard", component: ManagerDashComponent },
  { path: "manager-view-tickets", component: ManagerTicketsComponent },

  { path: "engineer-dashboard", component: EngineerDashComponent },

  { path: "view-ticket/:tid", component: ViewTicketComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
