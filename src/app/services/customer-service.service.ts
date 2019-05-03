import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse, HttpRequest, HttpHeaders } from '@angular/common/http';
import { Observable, EMPTY, throwError, from } from 'rxjs';

import { map } from "rxjs/operators";
import { catchError } from "rxjs/operators";





import { Customer } from '../customer';

@Injectable({
  providedIn: 'root'
})
export class CustomerServiceService {
  private baseUrl: string = "http://localhost:8080";
  private headers = new HttpHeaders({ 'Content-type': 'application/json' });
  private options = { headers: this.headers }

  private customer: Customer;


  constructor(private http: HttpClient) { }

  getCustomers() {
    // return this.http.get(this.baseUrl + '/getAllCustomers', this.options).pipe(map((response: Response) => response.json().catch(this.errorHandler)));
    return this.http.get(this.baseUrl + '/entry/getAllCustomers', this.options);
  }

  getCustomer(id: number) {
    return this.http.get(this.baseUrl + '/customer/' + id, this.options);
  }


  deleteCustomer(id: number) {
    return this.http.delete(this.baseUrl + '/deleteCustomer/' + id, this.options);//.pipe(map((response: Response) => response.json().catch(this.errorHandler)));
  }

  createCustomer(customer: Customer) {
    return this.http.post(this.baseUrl + '/entry/addCustomer', JSON.stringify(customer), this.options);//.pipe(map((response: Response) => response.json().catch(this.errorHandler)));
  }

  updateCustomer(id: number, customer: Customer) {
    return this.http.put(this.baseUrl + '/entry/updateCustomer/' + id, JSON.stringify(customer), this.options);//.pipe(map((response: Response) => response.json().catch(this.errorHandler)));
  }

  login(customer: Customer) {
    return this.http.post(this.baseUrl + '/entry/loginCustomer/', JSON.stringify(customer), this.options);
  }



  errorHandler(error: Response) {
    return Observable.throw(error || "No data");
  }

  setter(customer: Customer) {
    // this.customer.accountNo = accountNo;
    this.customer = customer;
  }

  getter() {
    return this.customer;
  }
}