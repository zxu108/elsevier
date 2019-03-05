import { Component, AfterContentInit, SecurityContext, NgZone, OnInit} from '@angular/core';
import { DomSanitizer } from '@angular/platform-browser';
import { Chart } from 'chart.js';
import { CenterDataService } from './center.service';

@Component({
  templateUrl: './center.component.html',
  styleUrls: ['./center.component.scss']
})

export class CenterComponent implements AfterContentInit, OnInit {
  title = 'zenwebbodypage';
  ct: Object;
  chart = []; // This will hold our chart info
  alerts = [];
  logoToShow: any;
  isImageLoading: boolean = false;
  isMapLoading: boolean = true;

  Maptitle: string = 'My first AGM project';
  public lat: number = 51.678418; // 39.7844603; 
  public lng: number = 7.809007; // -75.71229819999999; 
  public zoom: number;
  mapRslt: any[];
 
  constructor(private data: CenterDataService, private sanitizer: DomSanitizer, private ngZone: NgZone) { }
		  
  ngAfterContentInit(): void {
	  this.getCenter(16);
	  this.displayChart();
	  this.getImageFromService();
//	  console.log('Before map');
//	  this.getlatlng('3 isabella ct, hockessin, De 19707');
//	  this.lat = this.mapRslt[0].geometry.location.lat;
//	  this.lng = this.mapRslt[0].geometry.location.lng;	  
//	  console.log('gash ds cgdshgc adhgvdahgvhds ');
//	  console.log('lat: ' +this.lat);
//	  console.log('lng: ' +this.lng);	  
  }
  
  ngOnInit() {
	  console.log('before');
	  this.getlatlng('3 isabella ct, hockessin, De 19707');

	  console.log('middle: ' + JSON.stringify(this.mapRslt[0]));
      //verify result
      if (this.mapRslt[0].geometry === undefined || this.mapRslt[0].geometry === null) {
        return;
      }
	  console.log('after');
	  this.ngZone.run(() => {
          //get the place result

          //set latitude, longitude and zoom
          this.lat = this.mapRslt[0].geometry.location.lat();
          this.lng = this.mapRslt[0].geometry.location.lng();
          this.zoom = 12;
        });
  }
  
  
  // This service retrieves an image from backend database through controller and pass to html 
  // for display
  // Zhengyi Xu 
  // 2/27/2019
  getImageFromService() {
      this.isImageLoading = true;
      this.data.getCenterLogo('centerId1').subscribe(rslt => {
        this.createImageFromBlob(rslt);
        this.isImageLoading = false;
      }, error => {
        this.isImageLoading = false;
        console.log(error);
      });
  }
  
  createImageFromBlob(image: Blob) {
	   let reader = new FileReader();
	   reader.addEventListener("load", () => {
		   this.logoToShow = this.sanitizer.bypassSecurityTrustResourceUrl(reader.result);
	   }, false);

	   if (image) {
	      reader.readAsDataURL(image);
	   }
	}
  
  getCenter(Id: number): void {
	  	this.data.getCenterDetail(Id).subscribe(		 
	       resultObj => {this.ct = resultObj;
	                    console.log('result');
	                    console.log(this.ct);
	                  },	       
	       (error:any) => {
	    	   console.log('get center infor unsuccessful: '+error.message);
	    	   this.alerts.push ({
	    		   type: 'danger',
	    		   msg: 'Error! fetch data error: '+error.message
	    	   });
	       });
  }
  
  getlatlng(address: string): void {
	  	this.isMapLoading = true;
	  	this.data.getlatlng(address).subscribe(		 
	       resultObj => {
	    	   			this.mapRslt = resultObj;
	                    this.isMapLoading = false;
                        
	                    this.ngZone.run(() => {
	                        //set latitude, longitude and zoom
	                        this.lat = this.mapRslt.results[0].geometry.location.lat;
	                        this.lng = this.mapRslt.results[0].geometry.location.lng;
	                        
	                        console.log('lat = ' + this.lat);
	                        console.log('lng = ' + this.lng);
	                        this.zoom = 8;
	                      });
	                    
	                  },	       
	       (error:any) => {
	    	   console.log('get center infor unsuccessful: '+error.message);
	    	   this.alerts.push ({
	    		   type: 'danger',
	    		   msg: 'Error! fetch data error: '+error.message	    		  
	    	   });
	    	   this.isMapLoading = false;
	       });
}
  
  
  displayChart(): void {
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
  
}
