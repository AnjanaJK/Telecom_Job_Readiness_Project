import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { LoginComponent } from './login/login.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { AdminDashComponent } from './admin/admin-dash/admin-dash.component';
import { AdminAllCustComponent } from './admin/admin-all-cust/admin-all-cust.component';
import { CustomerDashComponent } from './customer/customer-dash/customer-dash.component';
import { ManagerDashComponent } from './manager/manager-dash/manager-dash.component';
import { EngineerDashComponent } from './engineer/engineer-dash/engineer-dash.component';
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
import { AddNewEngComponent } from './admin/add-new-eng/add-new-eng.component';
import { AddNewMngrComponent } from './admin/add-new-mngr/add-new-mngr.component';
import { EditMngrComponent } from './admin/edit-mngr/edit-mngr.component';
import { EditEngComponent } from './admin/edit-eng/edit-eng.component';



@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HeaderComponent,
    FooterComponent,
    AdminDashComponent,
    AdminAllCustComponent,
    CustomerDashComponent,
    ManagerDashComponent,
    EngineerDashComponent,
    AdminAllEngComponent,
    AdminAllMngrComponent,
    AddNewCustComponent,
    EditCustComponent,
    NewTicketComponent,
    ResolvedTicketsComponent,
    ProfileComponent,
    ChangePassComponent,
    ManagerTicketsComponent,
    ViewTicketComponent,
    AddNewEngComponent,
    AddNewMngrComponent,
    EditMngrComponent,
    EditEngComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
