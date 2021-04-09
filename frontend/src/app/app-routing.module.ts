
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EmployeeIndexComponent } from './employee/employee-index/employee-index.component';
import { ErrorComponent } from './error/error.component';
import { HomeComponent } from './home/home.component';

const routes: Routes = [
  { path: "", component: HomeComponent },
  { path: "ng-app", component: HomeComponent },
  { path: "employees", component: EmployeeIndexComponent },
  
  { path: "**", component: ErrorComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
