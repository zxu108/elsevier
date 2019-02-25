import { Component, AfterContentInit } from '@angular/core';
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

  constructor(private data: CenterDataService) { }

  ngAfterContentInit(): void {
     this.data.getCenterDetail(1).subscribe(
    		 
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
}
