import { HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CenterDataService {

  private headers = new HttpHeaders().append('Content-Type', 'application/json');

  constructor(private http: HttpClient) { }

  getCenterDetail(id: number) {
  const url = 'api/v1/center/' + id.toString();
  return this.http.get(url, {headers: this.headers});
  }
}
