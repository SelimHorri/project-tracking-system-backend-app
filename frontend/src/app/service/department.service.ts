import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { DepartmentsCollection } from '../model/collection/departments-collection';
import { Department } from '../model/entity/department';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DepartmentService {
  
  private apiUrl: string = environment.apiUrl;
  
  constructor(private http: HttpClient) {
    this.apiUrl = this.apiUrl + "/departments";
  }
  
  public findAll(): Observable<DepartmentsCollection> {
    return this.http.get<DepartmentsCollection>(this.apiUrl);
  }
  
  public findById(departmentId: number): Observable<Department> {
    return this.http.get<Department>(this.apiUrl + "/" + departmentId);
  }
  
  public save(department: Department): Observable<Department> {
    return this.http.post<Department>(this.apiUrl, department);
  }
  
  public update(department: Department): Observable<Department> {
    return this.http.put<Department>(this.apiUrl, department);
  }
  
  public deleteById(departmentId: number): Observable<any> {
    return this.http.delete<any>(this.apiUrl + "/" + departmentId);
  }
  
  
  
}






