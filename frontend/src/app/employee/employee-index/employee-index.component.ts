
import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { EmployeeProjectData } from 'src/app/model/dto/employee-project-data';
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
  public employeeProjectDatas!: EmployeeProjectData[];
  
  constructor(private employeeService: EmployeeService) {
    
  }
  
  ngOnInit(): void {
    this.findByEmployeeId(2);
  }
  
  public findByEmployeeId(employeeId: number): void {
    this.employeeService.findByEmployeeId(employeeId).subscribe(
      (employeeProjectDatas:EmployeeProjectData[]) => {
        this.employeeProjectDatas = employeeProjectDatas;
        console.log(JSON.stringify(this.employeeProjectDatas));
      },
      (error: HttpErrorResponse) => {
        console.log(error.message);
        alert(error.message);
      }
    );
  }
  
  
  
}
