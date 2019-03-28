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

  getPatient(patientId: string): Observable<any> {
	  const url = 'https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca/Patient/' + patientId.toString();
	  return this.http.get(url, {headers: this.headers})
	}

  getPatientConditions(patientId: string): Observable<any> {
	  const url = 'https://fhir-open.sandboxcerner.com/dstu2/0b8a0111-e8e6-4c26-a91c-5069cbc6b1ca/Condition?patient=' + patientId.toString();
	  return this.http.get(url, {headers: this.headers})
	}
	  
}
