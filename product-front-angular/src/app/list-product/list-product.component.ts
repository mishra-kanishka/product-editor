import {Component, OnInit} from '@angular/core';
import {Product} from '../model/product.model';
import {ApiService} from '../core/api.service';

@Component({
  selector: 'app-list-product',
  templateUrl: './list-product.component.html',
  styleUrls: ['./list-product.component.css']
})
export class ListProductComponent implements OnInit {

  products: Product[];

  constructor(private apiService: ApiService) { }

  ngOnInit() {
    this.apiService.getProducts()
      .subscribe( data => {
        this.products = data;
      });
  }

  deleteProduct(product: Product) {
    this.apiService.deleteProduct(product.id)
      .subscribe( data => {
        this.products = this.products.filter(u => u !== product);
      });
  }

  editProduct(product: Product) {
    // this.apiService.startedEditing.next(product.id);
    window.localStorage.setItem('editProductId', product.id.toString());
  }
}
