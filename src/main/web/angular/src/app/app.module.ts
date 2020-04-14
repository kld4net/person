import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
// import {ReactiveFormsModule} from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import {HttpClientModule} from '@angular/common/http';
import { AppComponent } from './app.component';
import { ApiService } from './api.service';
import { PersonDashboardModule} from './person-dashboard/person-dashboard.module';
// import {FormsModule} from '@angular/forms';


@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    // ReactiveFormsModule,
    HttpClientModule,
    // FormsModule,
    PersonDashboardModule
  ],
  providers: [ApiService],
  bootstrap: [AppComponent]
})
export class AppModule { }
