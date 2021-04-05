import { Observable } from 'rxjs';
import { ProjectsCollection } from './../model/collection/projects-collection';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
import { Project } from '../model/entity/project';

@Injectable({
  providedIn: 'root'
})
export class ProjectService {
  
  private apiUrl: string = environment.apiUrl;
  
  constructor(private http: HttpClient) {
    this.apiUrl = this.apiUrl + "/projects";
  }
  
  public findAll(): Observable<ProjectsCollection> {
    return this.http.get<ProjectsCollection>(this.apiUrl);
  }

  public findById(projectId: number): Observable<Project> {
    return this.http.get<Project>(this.apiUrl + "/" + projectId);
  }

  public save(Project: Project): Observable<Project> {
    return this.http.post<Project>(this.apiUrl, Project);
  }

  public update(Project: Project): Observable<Project> {
    return this.http.put<Project>(this.apiUrl, Project);
  }

  public deleteById(projectId: number): Observable<any> {
    return this.http.delete<any>(this.apiUrl + "/" + projectId);
  }
  
  
  
}
