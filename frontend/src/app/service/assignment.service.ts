import { AssignmentsCollection } from './../model/collection/assignments-collection';
import { Assignment } from './../model/entity/assignment';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AssignmentService {
  
  private apiUrl: string = environment.apiUrl;
  
  constructor(private http: HttpClient) {
    this.apiUrl = this.apiUrl + "/assignments";
  }
  
  public findAll(): Observable<AssignmentsCollection> {
    return this.http.get<AssignmentsCollection>(this.apiUrl);
  }
  
  public save(assignment: Assignment): Observable<Assignment> {
    return this.http.post<Assignment>(this.apiUrl, assignment);
  }
  
  
  
}
