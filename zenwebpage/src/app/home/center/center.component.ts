import { Component, AfterContentInit } from '@angular/core';
import { CenterDataService } from './center.service';

@Component({
  templateUrl: './center.component.html',
  styleUrls: ['./center.component.scss']
})

export class CenterComponent implements AfterContentInit {
  title = 'zenwebbodypage';
  ct: Object;

  constructor(private data: CenterDataService) { }

  ngAfterContentInit(): void {
          this.data.getCenterDetail(1).subscribe(
      resultObj => {this.ct = resultObj;
                    console.log('result');
                    console.log(this.ct);
                  }
       );
  }
}
