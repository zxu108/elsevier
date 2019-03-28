import { Component, AfterContentInit } from '@angular/core';
import { DataService } from './data.service';
import { HomeComponent } from './home/home.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})

export class AppComponent implements AfterContentInit {
  csu: Object;
  title = 'zenwebpage';
  homeComponent: HomeComponent;

  constructor(private data: DataService) { }

  ngAfterContentInit(): void {
  }
}



