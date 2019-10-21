import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Product} from '../model/product.model';
import {Observable, Subject} from 'rxjs';
import {ApiResponse} from '../model/api.response';

@Injectable()
export class ApiService {

  startedEditing = new Subject<number>();

  constructor(private http: HttpClient) { }
  baseUrl = 'http://localhost:8080/products/';

  getProducts(): Observable<Product[]> {
    return this.http.get<Product[]>(this.baseUrl);
  }

  getProductById(id: number): Observable<Product> {
    return this.http.get<Product>(this.baseUrl + id);
  }

  createProduct(product: Product): Observable<ApiResponse> {
    return this.http.post<ApiResponse>(this.baseUrl, product);
  }

  updateProduct(product: Product): Observable<ApiResponse> {
    return this.http.put<ApiResponse>(this.baseUrl + product.id, product);
  }

  deleteProduct(id: number): Observable<ApiResponse> {
    return this.http.delete<ApiResponse>(this.baseUrl + id);
  }
}
