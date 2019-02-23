import { HttpHeaders, HttpParams, HttpClient, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { CenterProfile } from './centerenrolldata.component';
import { Observable } from 'rxjs/Observable';

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
  
  createCenter(ceterData: CenterProfile, files: FileList):Observable<any> {
	const url = 'api/v1/center/File';
	let headers = new HttpHeaders();
	//this is the important step. You need to set content type as null
	headers.set('Content-Type', null);
	headers.set('Accept', "multipart/form-data");
	let params = new HttpParams().set('param1', 'test value');;
	const formData: FormData = new FormData();
	
	for (let i = 0; i < files.length; i++) {
	  formData.append('file', files[i], files[i].name);
	  console.log(files[i].name);
	} 
	console.log(JSON.stringify(ceterData));
	formData.append('CenterData', JSON.stringify(ceterData));
	return this.http.post(url, formData, {params, headers});
  }
  
}