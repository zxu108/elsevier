import { Component, AfterContentInit, ViewChild } from '@angular/core';
import { Chart } from 'chart.js';
import { CenterDataService } from './centerenroll.service';
import { CenterProfile } from './centerenrolldata.component';
import { isUndefined } from 'util';
import { ModalDirective } from 'ngx-bootstrap/modal';

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
  
  titleMessage: string;
  bodyMessage: string;
  actionMessage1: string;
  actionMessage2: string;
  action1: string;
  action2: string;

  constructor(private data: CenterDataService) { }

  ngAfterContentInit(): void {
	  	this.centerprofile.centerCountry = 'USA';
          this.data.getCenterDetail(1).subscribe(
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
	  let errMessage = '';
	  this.alerts = [];
	  let validatedEnroll: boolean = true;
	  
	  console.log('id:  '+ this.centerprofile.centerId);
	  
	  if (isUndefined(this.centerprofile.centerId)) {
		  errMessage += 'Please enter a center ID';
		  validatedEnroll = false;
	  }
	  
	  if (isUndefined(this.centerprofile.centerPassword)) {
		  errMessage += ' | Please enter a valid password';
		  validatedEnroll = false;
	  }
	  
	  if (isUndefined(this.centerprofile.centerName)) {
		  errMessage += ' | Please enter a valid center name';
		  validatedEnroll = false;
	  }
	  
	  if (isUndefined(this.centerprofile.centerOwnerFirstName)) {
		  errMessage += ' | Please enter owner frist name';
		  validatedEnroll = false;
	  }
	  
	  if (isUndefined(this.centerprofile.centerOwnerLastName)) {
		  errMessage += ' | Please enter owner last name';
		  validatedEnroll = false;
	  }
	  
	  if (isUndefined(this.centerprofile.centerAddress1)) {
		  errMessage += ' | Please enter center address';
		  validatedEnroll = false;
	  }	  
	  
	  if (isUndefined(this.centerprofile.centerCity)) {
		  errMessage += ' | Please enter center city';
		  validatedEnroll = false;
	  }	  
	  
	  if (isUndefined(this.centerprofile.centerZipCode)) {
		  errMessage += ' | Please enter center zip code';
		  validatedEnroll = false;
	  }	  
	  
	  if (isUndefined(this.centerprofile.centerOwnerEmail)) {
		  errMessage += ' | Please enter a valid center email address';
		  validatedEnroll = false;
	  }	  
	  
	  if (isUndefined(this.centerprofile.centerOwnerLandPhone) || (!this.centerprofile.centerOwnerLandPhone.match('^[0-9]{10}$')) {
		  errMessage += ' | Please enter a valid center phone number';
		  validatedEnroll = false;
	  }	  
	  
	  if (!validatedEnroll) {
		this.showAlert('danger', errMessage);
	  }
	  
	  return validatedEnroll;
  }
  
  	stateSelected(event): void { 		
  		this.centerprofile.city = event.target.value;
  		conole.log('city is: '+ this.centerprofile.city);  		
  	}
}
