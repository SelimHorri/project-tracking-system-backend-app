import { Observable } from 'rxjs';
import { UserCredentialsCollection } from './../model/collection/user-credentials-collection';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { UserCredential } from '../model/entity/user-credential';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserCredentialService {
  
  private apiUrl: string = environment.apiUrl;
  
  constructor(private http:HttpClient) {
    this.apiUrl = this.apiUrl + "/userCredentials";
  }
  
  public findAll(): Observable<UserCredentialsCollection> {
    return this.http.get<UserCredentialsCollection>(this.apiUrl);
  }

  public findById(userId: number): Observable<UserCredential> {
    return this.http.get<UserCredential>(this.apiUrl + "/" + userId);
  }

  public save(UserCredential: UserCredential): Observable<UserCredential> {
    return this.http.post<UserCredential>(this.apiUrl, UserCredential);
  }

  public update(UserCredential: UserCredential): Observable<UserCredential> {
    return this.http.put<UserCredential>(this.apiUrl, UserCredential);
  }

  public deleteById(userId: number): Observable<any> {
    return this.http.delete<any>(this.apiUrl + "/" + userId);
  }
  
}
