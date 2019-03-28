import { HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  private headers = new HttpHeaders().append('Content-Type', 'application/json');

 constructor(private http: HttpClient) { }

}
