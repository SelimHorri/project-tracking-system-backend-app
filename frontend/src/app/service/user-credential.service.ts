import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UserCredentialService {
  
  private apiUrl: string = environment.apiUrl;
  
  constructor() {
    this.apiUrl = this.apiUrl + "/userCredentials";
  }
  
  
  
}
