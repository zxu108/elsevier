import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';

@Injectable({
  providedIn: 'root'
})
export class CenterDataService {

  private headers = new HttpHeaders().append('Content-Type', 'application/json');

  constructor(private http: HttpClient) { }

  getCenterDetail(id: number): Observable<any> {
  const url = 'api/v1/center/' + id.toString();
  return this.http.get(url, {headers: this.headers})
  }
   
  getCenterLogo(centerId: string): Observable<Blob> {
	    return this.http.get('api/v1/center/Log/'+centerId, {responseType: "blob"});
	}
}
