import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule, HTTP_INTERCEPTORS} from '@angular/common/http';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { BodypageComponent } from './home/bodypage/bodypage.component';
import { CenterComponent } from './home/center/center.component';
import { FormsModule } from '@angular/forms';
import { AlertModule } from 'ngx-bootstrap/alert';
import { CommonModule } from '@angular/common';
import { ModalModule } from "ngx-bootstrap";
import { AgmCoreModule} from '@agm/core';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';

import { AppComponent } from './app.component';
import { DataService } from './data.service';
import { HttpErrorInterceptor } from './http-error.interceptor';

const appRoutes: Routes = [
                       {path: 'bodypage', component: BodypageComponent },
                        {path: 'center', component: CenterComponent }
                   ];

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    BodypageComponent,
    CenterComponent
  ],
  imports: [
	CommonModule,
	NgbModule,
	ModalModule.forRoot(),
    AlertModule.forRoot(),
	FormsModule,
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [
              DataService,
              {
              provide: HTTP_INTERCEPTORS,
              useClass: HttpErrorInterceptor,	  
              multi: true
              }
              ],
  bootstrap: [AppComponent],
  exports: [ RouterModule, ModalModule]
})
export class AppModule { }
