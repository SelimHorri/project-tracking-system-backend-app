import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { EmployeesCollection } from '../model/collection/employees-collection';
import { EmployeeProjectData } from '../model/dto/employee-project-data';
import { Employee } from '../model/entity/employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  
  private apiUrl: string = environment.apiUrl;
  
  constructor(private http: HttpClient) {
    this.apiUrl = this.apiUrl + "/employees";
  }
  
  public findAll(): Observable<EmployeesCollection> {
    return this.http.get<EmployeesCollection>(this.apiUrl);
  }
  
  public findById(employeeId: number): Observable<Employee> {
    return this.http.get<Employee>(this.apiUrl + "/" + employeeId);
  }
  
  public save(employee: Employee): Observable<Employee> {
    return this.http.post<Employee>(this.apiUrl, employee);
  }
  
  public update(employee: Employee): Observable<Employee> {
    return this.http.put<Employee>(this.apiUrl, employee);
  }
  
  public deleteById(employeeId: number): Observable<any> {
    return this.http.delete<any>(this.apiUrl + "/" + employeeId);
  }
  
  public findByEmployeeId(employeeId: number): Observable<EmployeeProjectData[]> {
    return this.http.get<EmployeeProjectData[]>(this.apiUrl + "/display-projects/" + employeeId);
  }
  
  
  
}




