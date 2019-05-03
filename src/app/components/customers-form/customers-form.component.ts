import { Component, OnInit } from '@angular/core';
import { Customer } from 'src/app/customer';
import { Router } from '@angular/router';
import { CustomerServiceService } from 'src/app/services/customer-service.service';


@Component({
  selector: 'app-customers-form',
  templateUrl: './customers-form.component.html',
  styleUrls: ['./customers-form.component.css']
})
export class CustomersFormComponent implements OnInit {

  private customer: Customer;

  constructor(private customerService: CustomerServiceService, private router: Router) { }

  ngOnInit() {
    this.customer = this.customerService.getter();
  }

  submitForm() {
    if (this.customer.accountNo == undefined) {
      this.customerService.createCustomer(this.customer).subscribe((customer) => {
        console.log(customer);
        this.router.navigate(['']);
      }, (error) => {
        console.log(error);
      });
    }

    else {
      this.customerService.updateCustomer((Number)(this.customer.accountNo), this.customer).subscribe((customer) => {
        console.log(customer);
        this.router.navigate(['']);
      }, (error) => {
        console.log("unable to update the data");
      });
    }
  }

}
