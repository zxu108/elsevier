import { Component, AfterContentInit } from '@angular/core';
import { DataService } from './data.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})

export class AppComponent implements AfterContentInit {
  csu: Object;
  title = 'zenwebpage';

  constructor(private data: DataService) { }

  ngAfterContentInit(): void {
       this.data.getCustInfo().subscribe(
      resultObj => {this.csu = resultObj;
                    console.log('result');
                    console.log(this.csu);
                  }
       );
  }
}
