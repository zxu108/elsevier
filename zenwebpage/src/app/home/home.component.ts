import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
	selector: 'home-app',
	templateUrl: './home.component.html',
	styleUrls: ['./home.component.scss']
})

export class HomeComponent implements OnInit {
  title: string = 'zenwebpage';
  pagenum: number;
	
constructor(private router: Router) { }

	ngOnInit() {
	console.log('tst 111');
}
//  ngAfterContentInit(): void {
//  }
  
  setActive(id: number): void {
	  this.pagenum = id;
  }
  
  	goToPageFront(pageId: string): void {
	  console.log('test one');
		this.router.navigate(['frontpage']);  
	  } 
  	
  	goToPageBody(pageId: string): void {
	  console.log('test three');
		this.router.navigate(['bodypage']);  
	  } 
 
  	goToPagePrinters(pageId: string): void {
 		  console.log('test four');
 			this.router.navigate(['printers']);  
  	
}
}
