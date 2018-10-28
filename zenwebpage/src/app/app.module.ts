import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { FrontpageComponent } from './home/frontpage/frontpage.component';

import { AppComponent } from './app.component';
import { DataService } from './data.service';

const appRoutes: Routes = [
                   		{path: 'frontpage', component: FrontpageComponent }
                   ];


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    FrontpageComponent
  ],
  entryComponents:[HomeComponent],
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
