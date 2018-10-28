import { Component, AfterContentInit } from '@angular/core';

@Component({
  templateUrl: './frontpage.component.html',
  styleUrls: ['./frontpage.component.scss']
})

export class FrontpageComponent implements AfterContentInit {
  title = 'zenwebpage';

  constructor() { }

  ngAfterContentInit(): void {
	  console.log('test two');
  }
}
