import {Component, OnInit} from '@angular/core';
import {Product} from '../model/product.model';
import {ApiService} from '../core/api.service';
import {DataService} from '../core/data.service';

@Component({
  selector: 'app-list-product',
  templateUrl: './list-product.component.html',
  styleUrls: ['./list-product.component.css']
})
export class ListProductComponent implements OnInit {

  products: Product[];
  currentProduct: Product;

  constructor(private apiService: ApiService, private dataService: DataService) { }

  ngOnInit() {
    this.apiService.getProducts()
      .subscribe( data => {
        this.products = data;
      });
    this.dataService.currentProduct.subscribe(product => this.currentProduct = product);
  }

  deleteProduct(product: Product) {
    this.apiService.deleteProduct(product.id)
      .subscribe( data => {
        this.products = this.products.filter(u => u !== product);
      });
  }

  editProduct(product: Product) {
    // window.localStorage.setItem('editProductId', product.id.toString());
    this.dataService.changeProduct(product);
  }
}
