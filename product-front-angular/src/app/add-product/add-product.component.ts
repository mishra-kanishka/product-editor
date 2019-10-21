import { Component, OnInit } from '@angular/core';
import {Detail} from '../model/details.model';
import {NgForm} from '@angular/forms';
import {Router} from '@angular/router';
import {ApiService} from '../core/api.service';
import {Product} from '../model/product.model';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent implements OnInit {

  details: Detail[] = [{
    key: '',
    value: ''
  }];

  constructor(private apiService: ApiService, private router: Router) { }

  ngOnInit() {
  }

  addDetailsSection() {
    this.details.push(new Detail('', ''));
  }

  onSubmit(form: NgForm) {
    console.log(form.value);
    const value = form.value;
    const productDetails: Detail[] = [];
    for (let i = 0; i < Object.keys(value.details).length / 2; i++) {
      productDetails.push(new Detail(value.details['key_' + i], value.details['value_' + i]));
    }
    const newProduct = new Product(
      undefined,
      value.name,
      value.category,
      value.code,
      value.price,
      productDetails
    );
    this.apiService.createProduct(newProduct)
      .subscribe( data => {
        this.router.navigate(['list-products']);
      });
  }
}
