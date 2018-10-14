import { HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  private headers = new HttpHeaders().append('Content-Type', 'application/json');

 constructor(private http: HttpClient) { }

  getCustInfo() {
    const url = 'http://localhost:8080/api/v1/test/CustInfo/4';
  return this.http.get(url, {headers: this.headers});
  }

//  private handleError(error: any) {
//    return Observable.throw(error.error);
//  }
}
