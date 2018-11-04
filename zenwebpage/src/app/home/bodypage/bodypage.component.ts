import { Component, AfterContentInit } from '@angular/core';

@Component({
  templateUrl: './bodypage.component.html',
  styleUrls: ['./bodypage.component.scss']
})

export class BodypageComponent implements AfterContentInit {
  title = 'zenwebbodypage';

  constructor() { }

  ngAfterContentInit(): void {
	  console.log('test ten');
  }
}
