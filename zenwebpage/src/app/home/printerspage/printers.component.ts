import { Component, AfterContentInit } from '@angular/core';

@Component({
  templateUrl: './printers.component.html',
  styleUrls: ['./printers.component.scss']
})

export class PrintersComponent implements AfterContentInit {
  title = 'zenwebbodypage';

  constructor() { }

  ngAfterContentInit(): void {
console.log('tetsfdagfd');
  }
}
