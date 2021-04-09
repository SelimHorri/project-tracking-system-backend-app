
import { Component, OnInit } from '@angular/core';
import { Employee } from 'src/app/model/entity/employee';
import { EmployeeService } from 'src/app/service/employee.service';

@Component({
  selector: 'app-employee-index',
  templateUrl: './employee-index.component.html',
  styleUrls: ['./employee-index.component.css']
})
export class EmployeeIndexComponent implements OnInit {
  
  public employees!: Employee[];
  public employee!: Employee;
  
  constructor(private employeeService: EmployeeService) {
      
  }
  
  ngOnInit(): void {
    
  }
  
  
  
}
