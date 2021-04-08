import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { EmployeesCollection } from '../model/collection/employees-collection';
import { EmployeeService } from '../service/employee.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  
  constructor(private employeeService: EmployeeService) {
    
  }
  
  ngOnInit() {
    this.findAll();
  }
  
  public findAll(): void {
    this.employeeService.findAll().subscribe(
      (response: EmployeesCollection) => {
        response.employees.forEach((e) => {
          console.log(JSON.stringify(e) + " : " + e.email);
        });
      },
      (error: HttpErrorResponse) => {
        console.log(error.message);
        alert(error.message);
      }
    );
  }
  
  
  
}
