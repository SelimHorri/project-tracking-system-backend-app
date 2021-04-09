
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AssignmentService } from './service/assignment.service';
import { DepartmentService } from './service/department.service';
import { EmployeeService } from './service/employee.service';
import { LocationService } from './service/location.service';
import { ProjectService } from './service/project.service';
import { UserCredentialService } from './service/user-credential.service';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { NavbarComponent } from './navbar/navbar.component';
import { FooterComponent } from './footer/footer.component';
import { EmployeeIndexComponent } from './employee/employee-index/employee-index.component';
import { EmployeeTeamComponent } from './employee/employee-team/employee-team.component';
import { EmployeeInfoComponent } from './employee/employee-info/employee-info.component';
import { ManagerIndexComponent } from './manager/manager-index/manager-index.component';
import { ManagerInfoComponent } from './manager/manager-info/manager-info.component';
import { ManagerTeamComponent } from './manager/manager-team/manager-team.component';
import { ErrorComponent } from './error/error.component';
import { AdminIndexComponent } from './admin/admin-index/admin-index.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    NavbarComponent,
    FooterComponent,
    EmployeeIndexComponent,
    EmployeeTeamComponent,
    EmployeeInfoComponent,
    ManagerIndexComponent,
    ManagerInfoComponent,
    ManagerTeamComponent,
    ErrorComponent,
    AdminIndexComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    AppRoutingModule
  ],
  providers: [
    EmployeeService,
    UserCredentialService,
    ProjectService,
    AssignmentService,
    DepartmentService,
    LocationService
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
  
}


