import { Component, AfterContentInit, ViewChild} from '@angular/core';
import { Chart } from 'chart.js';
import { CenterDataService } from './centerenroll.service';
import { CenterProfile, CheckInputFlags } from './centerenrolldata.component';
import { isUndefined } from 'util';
import { ModalDirective } from 'ngx-bootstrap/modal';

//import * as FileSaver from 'file-saver';
import * as moment from 'moment';

@Component({
  templateUrl: './centerenroll.component.html',
  styleUrls: ['./centerenroll.component.scss']
})

export class CenterenrollComponent implements AfterContentInit {
	@ViewChild('modal') modal: ModalDirective;
  title = 'zenwebbodypage';
  ct: Object;
  chart = []; // This will hold our chart info
  centerId: string = '';
  centerName: string = 'please enter a name of your center';
  centerprofile: CenterProfile = new CenterProfile;
  alerts = [];
  filelocation: FileList;
  
  titleMessage: string;
  bodyMessage: string;
  actionMessage1: string;
  actionMessage2: string;
  action1: string;
  action2: string;
  
  checkFlags: CheckInputFlags = new CheckInputFlags;


  constructor(private centerService: CenterDataService) { }

  ngAfterContentInit(): void {
	  	this.centerprofile.centerCountry = 'USA';
          this.centerService.getCenterDetail(1).subscribe(
      resultObj => {this.ct = resultObj;
                    console.log('result');
                    console.log(this.ct);
                  }
       );

  
  console.log('test one');
  
  this.chart = new Chart('canvas', {
  type: 'bar',
  data: {
    labels: ["Africa", "Asia", "Europe", "Latin America", "North America"],
    datasets: [
      {
        label: "Population (millions)",
        backgroundColor: ["#3e95cd", "#8e5ea2","#3cba9f","#e8c3b9","#c45850"],
        data: [2478,5267,734,784,433]
      }
    ]
  },
  options: {
    legend: { display: false },
    title: {
      display: true,
      text: 'Predicted world population (millions) in 2050'
    }
  }
  
  });
  }  
   
  showAlert(type: string, message: string): void {
	  this.alerts.push({
		  type: type,
		  msg: message
	  });
	  this.alerts = this.alerts.map((alert: any) => Object.assign({}, alert));
  }
  
  handleModal(bodyMsg, TitleMsg, ActionMsg1, ActionMsg2, ActionFunction1, ActionFunction2): void {
	  
	  if (this.validateEnroll()) {
		  		this.showConfirmationWindow(bodyMsg, TitleMsg, ActionMsg1, ActionMsg2, ActionFunction1, ActionFunction2);
	  } else {
		 this.hideModal();
	  }
	  
  }
  
  hideModal(): void {
	  this.modal.hide();
  }
  
  
  
  SaveYes(): void {
	  console.log('yes clicked');
	  this.createNewCenter()
	  this.modal.hide();	  
  }
  
  SaveNo(): void {	  
	  console.log('no clicked');
	  this.modal.hide();
  }
   
  showConfirmationWindow(bodyMsg, TitleMsg, ActionMsg1, ActionMsg2, ActionFunction1, ActionFunction2): void { 
	  this.titleMessage=TitleMsg; 
	  this.bodyMessage=bodyMsg;
	  this.actionMessage1=ActionMsg1;
	  this.actionMessage2=ActionMsg2;
	  this.action1=ActionFunction1;
	  this.action2=ActionFunction2;
	  this.modal.show();
  }
  
  
  validateEnroll(): boolean {
	  this.alerts = [];
	  let validatedEnroll: boolean = true;
	  
	  this.checkFlags = new CheckInputFlags;
	  
	  console.log('id:  '+ this.centerprofile.centerId);
	  
	  if (this.isUndefinedOrNull(this.centerprofile.centerId)) {
		  console.log('gdasgdh');
		  validatedEnroll = false;
		  this.checkFlags.centerId = 'highlightedBox';
	  }
		  
	  if (this.isUndefinedOrNull(this.centerprofile.centerPassword)) {
		  validatedEnroll = false;
		  this.checkFlags.passWord = 'highlightedBox';
	  }
	  
	  if (this.isUndefinedOrNull(this.centerprofile.centerName)) {
		  validatedEnroll = false;
		  this.checkFlags.centerName = 'highlightedBox';
	  }
	  
	  if (this.isUndefinedOrNull(this.centerprofile.centerOwnerFirstName)) {
		  validatedEnroll = false;
		  this.checkFlags.ownerFirstName = 'highlightedBox';
	  }
	  
	  if (this.isUndefinedOrNull(this.centerprofile.centerOwnerLastName)) {
		  validatedEnroll = false;
		  this.checkFlags.ownerLastName = 'highlightedBox';
	  }
	  
	  if (this.isUndefinedOrNull(this.centerprofile.centerAddress1)) {
		  validatedEnroll = false;
		  this.checkFlags.address1 = 'highlightedBox';
	  }	  
	  
	  if (this.isUndefinedOrNull(this.centerprofile.centerCity)) {
		  validatedEnroll = false;
		  this.checkFlags.city = 'highlightedBox';
	  }	  
	  
	  if (this.isUndefinedOrNull(this.centerprofile.centerState)) {
		  validatedEnroll = false;
		  this.checkFlags.state = 'highlightedBox';
	  }	  
	  
	  if (this.isUndefinedOrNull(this.centerprofile.centerZipCode)) {
		  validatedEnroll = false;
		  this.checkFlags.zip = 'highlightedBox';
	  }	  
	  	  
	  if (this.isUndefinedOrNull(this.centerprofile.centerOwnerEmail)) {
		  validatedEnroll = false;
		  this.checkFlags.email = 'highlightedBox';
	  }	  
	  
	  if (this.isUndefinedOrNull(this.centerprofile.centerOwnerPhone) || (!this.centerprofile.centerOwnerPhone.match('^[0-9]{10}$'))) {
		  validatedEnroll = false;
		  this.checkFlags.phone = 'highlightedBox';
	  }	  
	  
	  if (!validatedEnroll) {
		this.showAlert('danger', 'Please enter the missing fields');
	  }
	  
	  return validatedEnroll;
  }
  
  	stateSelected(event): void { 		
  		this.centerprofile.centerState = event.target.value;
  		console.log('State is: '+ this.centerprofile.centerState);  		
  	}
  	
  	isUndefinedOrNull = function(val) {
  	    return isUndefined(val) || val === null || val==='';
  	}
  	
  	getLogFile(event): void {
  		this.filelocation = event.target.files;
  		console.log('file is: '+ this.filelocation);

  	}
  	
  	createNewCenter(): void {
  		this.centerprofile.centerCloseStartDate = new Date();
  		this.centerprofile.centerOpenStatus = true;
        this.centerService.createCenter(this.centerprofile, this.filelocation).subscribe(
        	resultObj => {this.ct = resultObj;
                  		console.log(this.ct);
     		    	   this.alerts.push ({
    		    		   type: 'success',
    		    		   msg: 'Congratulation! Your center is successfully created.'
    		    	   });
                	},
        	
        	(error:any) => {
        		    	   console.log('Create center unsuccessful: '+error.message);
        		    	   this.alerts.push ({
        		    		   type: 'danger',
        		    		   msg: 'Error! create center error: '+error.message
        		    	   });
        		       }
     );
  		
  	}
}
