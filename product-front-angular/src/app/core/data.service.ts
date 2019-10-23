import {Injectable} from '@angular/core';
import {BehaviorSubject} from 'rxjs';
import {Product} from '../model/product.model';
import {Detail} from '../model/details.model';

@Injectable()
export class DataService {

  details: Detail[] = [{ key: '', value: ''}];

  product = new Product(0, '', '', 0, 0, this.details);

  private productSource = new BehaviorSubject<Product>(this.product);
  currentProduct = this.productSource.asObservable();

  constructor() {}

  changeProduct(product: Product) {
    this.productSource.next(product);
  }

}
