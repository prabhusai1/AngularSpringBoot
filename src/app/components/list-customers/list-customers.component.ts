import { Component, OnInit } from '@angular/core';
import { Customer } from 'src/app/customer';
import { CustomerServiceService } from 'src/app/services/customer-service.service';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';

@Component({
  selector: 'app-list-customers',
  templateUrl: './list-customers.component.html',
  styleUrls: ['./list-customers.component.css']
})
export class ListCustomersComponent implements OnInit {

  private customers: Customer[];

  //private custs: Observable<Customer[]>;

  constructor(private customerService: CustomerServiceService, private route: Router, private customer: Customer) { }

  ngOnInit() {
    this.customerService.getCustomers().subscribe(
      (customers: Customer[]) => {
        console.log(customers);

        this.customers = customers;
        //this.custs = response;
      }, (error) => {
        console.log(error);
      })
  }

  deleteCustomer(customer) {
    this.customerService.deleteCustomer(customer.accountNo).subscribe((data) => {
      this.customers.splice(this.customers.indexOf(customer), 1);
    }, (error) => {
      console.log("failed to delete");
    })
  }

  updateCustomer(accountNo, customer) {
    this.customerService.setter(customer);
    this.route.navigate(['addOrUpdate']);
  }

  createCustomer() {
    let customer = new Customer();
    this.customerService.setter(customer);
    this.route.navigate(['addOrUpdate'])
  }

  loginCustomer(customer){
    this.customerService.login(customer);
  }


}
