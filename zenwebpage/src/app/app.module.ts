import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { FrontpageComponent } from './home/frontpage/frontpage.component';
import { BodypageComponent } from './home/bodypage/bodypage.component';
import { PrintersComponent } from './home/printerspage/printers.component';

import { AppComponent } from './app.component';
import { DataService } from './data.service';

const appRoutes: Routes = [
                   		{path: 'frontpage', component: FrontpageComponent },
                   		{path: 'bodypage', component: BodypageComponent },
                  		{path: 'printers', component: PrintersComponent }
                   ];


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    FrontpageComponent,
    BodypageComponent,
    PrintersComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [DataService],
  bootstrap: [AppComponent],
  exports: [ RouterModule ]
})
export class AppModule { }
