
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminIndexComponent } from './admin/admin-index/admin-index.component';
import { EmployeeIndexComponent } from './employee/employee-index/employee-index.component';
import { ErrorComponent } from './error/error.component';
import { HomeComponent } from './home/home.component';
import { ManagerIndexComponent } from './manager/manager-index/manager-index.component';

const routes: Routes = [
  /**
   * Home path
   */
  { path: "", component: HomeComponent },
  { path: "ng", component: HomeComponent },
  
  /**
   * Employee paths
   */
  { path: "ng/employees", component: EmployeeIndexComponent },
  { path: "ng/employees/employee-index", component: EmployeeIndexComponent },
  
  /**
   * Manager paths
   */
  { path: "ng/managers", component: ManagerIndexComponent },
  { path: "ng/managers/manager-index", component: ManagerIndexComponent },
  
  /**
   * Admin paths
   */
  { path: "ng/admins/admin-index", component: AdminIndexComponent },
  { path: "ng/admins/employee-index", component: AdminIndexComponent },
  
  
  
  /**
   * Error paths
   */
  { path: "**", component: ErrorComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
