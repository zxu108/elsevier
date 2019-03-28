import { Component, AfterContentInit, SecurityContext, OnInit} from '@angular/core';
import { DomSanitizer } from '@angular/platform-browser';
import { Chart } from 'chart.js';
import { CenterDataService } from './center.service';

@Component({
  templateUrl: './center.component.html',
  styleUrls: ['./center.component.scss']
})

export class CenterComponent implements AfterContentInit, OnInit {
  title = 'patientCenterpage';
  alerts = [];
  loading: boolean = true;

  patientConditions: any[];
  patientInfo: any;
  pageSize: number = 15;
  patientId: string = '4342009';
  sortOrderName: boolean = true;
  sortOrderDate: boolean = true;
  
  page: number = 1;
  totalEntries: number;
  
  pIds: Array<string> = ['4342009', '4342010', '4342011', '4342012']; // known patient ID list

  constructor(private data: CenterDataService, private sanitizer: DomSanitizer) {
  }
		  
  ngAfterContentInit(): void {
	  this.getPatient(this.patientId); //4342009-4342012
	  this.getPatientConditions(this.patientId);
  }
  
  ngOnInit() {
  }
	 
  getPatient(Id: string): void {
	  	this.data.getPatient(Id).subscribe(		 
	       resultObj => {
	                    this.patientInfo = resultObj;
	                  },	       
	       (error:any) => {
	    	   console.log('get patient infor unsuccessful: '+error.message);
	    	   this.alerts.push ({
	    		   type: 'danger',
	    		   msg: 'Error! fetch data error: '+error.message
	    	   });
	       });
}

  getPatientConditions(Id: string): void {
	  	this.data.getPatientConditions(Id).subscribe(		 
	       resultObj => {
	                    this.patientConditions = resultObj.entry;
	                    this.totalEntries = resultObj.total;
	                    this.loading = false;
	                  },	       
	       (error:any) => {
	    	   console.log('get patient condition infor unsuccessful: '+error.message);
	    	   this.loading = false;
	    	   this.alerts.push ({
	    		   type: 'danger',
	    		   msg: 'Error! fetch data error: '+error.message
	    	   });
	       });
}

  resorting(id: string): void {
	if (id ==='1') {
		if (this.sortOrderName === true) {
			this.patientConditions.sort(function(a,b){return a.resource.code.text.localeCompare(b.resource.code.text)})
			this.sortOrderName = false;
		} else {
			this.patientConditions.sort(function(a,b){return b.resource.code.text.localeCompare(a.resource.code.text)})
			this.sortOrderName = true;	
		}		
	}
	
	if (id ==='2') {
		if (this.sortOrderDate === true) {
			this.patientConditions.sort(function(a,b){return a.resource.dateRecorded.localeCompare(b.resource.dateRecorded)})
			this.sortOrderDate = false;
		} else {
			this.patientConditions.sort(function(a,b){return b.resource.dateRecorded.localeCompare(a.resource.dateRecorded)})
			this.sortOrderDate = true;	
		}		
	}	
  }
  
  
  selectId(event): void {
	  this.patientId = event.target.value;
	  this.loading=true;
	  this.getPatient(this.patientId); 
	  this.getPatientConditions(this.patientId);  
  }
 
}
