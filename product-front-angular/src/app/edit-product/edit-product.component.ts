import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import {ApiService} from '../core/api.service';
import {Product} from '../model/product.model';
import {NgForm} from '@angular/forms';
import {DataService} from '../core/data.service';

@Component({
  selector: 'app-edit-product',
  templateUrl: './edit-product.component.html',
  styleUrls: ['./edit-product.component.css']
})
export class EditProductComponent implements OnInit, AfterViewInit {
  @ViewChild('ef', {static: false}) editForm: NgForm;

  editedProduct: Product;

  constructor(private apiService: ApiService, private dataService: DataService) {
    // this.editedProductIndex = +window.localStorage.getItem('editProductId');
    this.dataService.currentProduct.subscribe(product => this.editedProduct = product);
  }

  ngOnInit() { }

  ngAfterViewInit(): void {
    console.log(this.editedProduct);
    setTimeout(() => {
      this.editForm.setValue(this.editedProduct);
    }, );
  }

  onSubmit(form: NgForm) {
    console.log(form.value);
  }
}
