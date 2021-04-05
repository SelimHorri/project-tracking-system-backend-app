import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class LocationService {
  
  private apiUrl: string = environment.apiUrl;
  
  constructor() {
    this.apiUrl = this.apiUrl + "/locations";
  }
  
  
  
}
