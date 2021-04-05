import { EmployeesCollection } from './model/dto/employees-collection';
import { Component, OnInit } from '@angular/core';
import { EmployeeService } from './service/employee.service';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  
  constructor(private employeeService: EmployeeService) {
    
  }
  
  ngOnInit() {
    this.findAll();
  }
  
  public findAll(): void {
    this.employeeService.findAll().subscribe(
      (response: EmployeesCollection) => {
        response.employees.forEach((e) => {
          console.log(e.firstName + " " + e.lastName + " : " + e.email);
        });
      },
      (error: HttpErrorResponse) => {
        console.log(error.message);
        alert(error.message);
      }
    );
  }
  
  
  
}



