import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ListCustomersComponent } from './components/list-customers/list-customers.component';
import { CustomersFormComponent } from './components/customers-form/customers-form.component';
import { RouterModule, Routes } from '@angular/router';
import { CustomerServiceService } from './services/customer-service.service';

const routes: Routes = [
  { path: '', component: ListCustomersComponent }, //This is to list all the customers
  { path: 'addOrUpdate', component: CustomersFormComponent } //This form is for adding and updating customers
]

@NgModule({
  declarations: [
    AppComponent,
    ListCustomersComponent,
    CustomersFormComponent
  ],
  imports: [
    FormsModule,
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    RouterModule.forRoot(routes)
  ],
  providers: [CustomerServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
