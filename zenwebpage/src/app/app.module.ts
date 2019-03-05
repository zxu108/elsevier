import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule, HTTP_INTERCEPTORS} from '@angular/common/http';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { FrontpageComponent } from './home/frontpage/frontpage.component';
import { BodypageComponent } from './home/bodypage/bodypage.component';
import { PrintersComponent } from './home/printerspage/printers.component';
import { CenterComponent } from './home/center/center.component';
import { CenterenrollComponent } from './home/centerenroll/centerenroll.component';
import { FormsModule } from '@angular/forms';
import { AlertModule } from 'ngx-bootstrap/alert';
import { CommonModule } from '@angular/common';
import { ModalModule } from "ngx-bootstrap";
import { AgmCoreModule} from '@agm/core';

import { AppComponent } from './app.component';
import { DataService } from './data.service';
import { HttpErrorInterceptor } from './http-error.interceptor';

const appRoutes: Routes = [
                   		{path: 'frontpage', component: FrontpageComponent },
                       {path: 'bodypage', component: BodypageComponent },
                        {path: 'center', component: CenterComponent },
                        {path: 'centerenroll', component: CenterenrollComponent },                       
                  		{path: 'printers', component: PrintersComponent }
                   ];

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    FrontpageComponent,
    BodypageComponent,
    CenterComponent,
    CenterenrollComponent,
    PrintersComponent
  ],
  imports: [
	CommonModule,
	ModalModule.forRoot(),
    AlertModule.forRoot(),
	FormsModule,
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes),
    AgmCoreModule.forRoot({apiKey: 'AIzaSyAi1hgsq5UmT-y4VjBKqqlqGN8fbYP8ODg'})
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
