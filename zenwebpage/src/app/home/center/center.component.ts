/// <reference types="@types/googlemaps" />
import { Component, AfterContentInit, SecurityContext, NgZone, OnInit, ViewChild} from '@angular/core';
import { DomSanitizer } from '@angular/platform-browser';
import { Chart } from 'chart.js';
import { CenterDataService } from './center.service';
import { MapsAPILoader} from '@agm/core';

declare var google: any;

@Component({
  templateUrl: './center.component.html',
  styleUrls: ['./center.component.scss']
})

export class CenterComponent implements AfterContentInit, OnInit {
  title = 'zenwebbodypage';
  @ViewChild('gmap') gmapElement: any;
  ct: Object;
  chart = []; // This will hold our chart info
  alerts = [];
  logoToShow: any;
  isImageLoading: boolean = false;
  geocoder: google.maps.Geocoder;
  map: google.maps.Map;

  public lat: number; 
  public lng: number; 
  public zoom: number;
 
  constructor(public mapsApiLoader: MapsAPILoader, private data: CenterDataService, private sanitizer: DomSanitizer, private ngZone: NgZone) {
	  
	  this.mapsApiLoader.load().then(() => {
	      this.geocoder = new google.maps.Geocoder();
	    });
  }
		  
  ngAfterContentInit(): void {
	  this.getCenter(16);
	  this.displayChart();
	  this.getImageFromService();
  }
  
  ngOnInit() {
	  console.log('before 1');
	  this.initializGMap();
	  console.log('before');
	  	  
	  this.findLocation('3 isabella ct, hockessin, De 19707');
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
  
  // this function initialize the google map services
  initializGMap(): void {
	    this.geocoder = new google.maps.Geocoder();
	    let mapProp = {
	    	      center: new google.maps.LatLng(18.5793, 73.8143),
	    	      zoom: 10,
	    	      mapTypeId: google.maps.MapTypeId.ROADMAP
	    	    };
	    	    this.map = new google.maps.Map(this.gmapElement.nativeElement, mapProp);
	  }
  
  // this function converts address to lat and lng location for google map
  findLocation(address): void {
	    if (!this.geocoder) this.geocoder = new google.maps.Geocoder()
	    this.geocoder.geocode({
	      'address': address
	    }, (results, status) => {
	      if (status == google.maps.GeocoderStatus.OK) {
	    	  this.map.setZoom(10);
	    	  this.map.setCenter(results[0].geometry.location);
	    	  this.lat = results[0].geometry.location.lat();
	    	  this.lng = results[0].geometry.location.lng();
	          var marker = new google.maps.Marker({
	              map: this.map,
	              position: results[0].geometry.location
	          });
	      } else {
	        alert("Sorry, this search produced no results for the reason: "+ status);
	      }
	    })
	  }
  
}
