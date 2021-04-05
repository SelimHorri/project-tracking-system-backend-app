import { Observable } from 'rxjs';
import { LocationsCollection } from './../model/collection/locations-collection';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class LocationService {
  
  private apiUrl: string = environment.apiUrl;
  
  constructor(private http: HttpClient) {
    this.apiUrl = this.apiUrl + "/locations";
  }
  
  public findAll(): Observable<LocationsCollection> {
    return this.http.get<LocationsCollection>(this.apiUrl);
  }

  public findById(locationId: number): Observable<Location> {
    return this.http.get<Location>(this.apiUrl + "/" + locationId);
  }

  public save(Location: Location): Observable<Location> {
    return this.http.post<Location>(this.apiUrl, Location);
  }

  public update(Location: Location): Observable<Location> {
    return this.http.put<Location>(this.apiUrl, Location);
  }

  public deleteById(locationId: number): Observable<any> {
    return this.http.delete<any>(this.apiUrl + "/" + locationId);
  }
  
  
  
}






