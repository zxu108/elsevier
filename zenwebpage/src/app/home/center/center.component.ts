import { Component, AfterContentInit, SecurityContext} from '@angular/core';
import { DomSanitizer } from '@angular/platform-browser';
import { Chart } from 'chart.js';
import { CenterDataService } from './center.service';

@Component({
  templateUrl: './center.component.html',
  styleUrls: ['./center.component.scss']
})

export class CenterComponent implements AfterContentInit {
  title = 'zenwebbodypage';
  ct: Object;
  chart = []; // This will hold our chart info
  alerts = [];
  logoToShow: any;
  isImageLoading: boolean = false;

  Maptitle: string = 'My first AGM project';
  lat: number = 51.678418;
  lng: number = 7.809007;

  constructor(private data: CenterDataService, private sanitizer: DomSanitizer) { }

  ngAfterContentInit(): void {
	  this.getCenter(16);
	  this.displayChart();
	  this.getImageFromService();
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
