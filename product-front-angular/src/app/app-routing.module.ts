import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ListProductComponent} from './list-product/list-product.component';
import {AddProductComponent} from './add-product/add-product.component';
import {EditProductComponent} from './edit-product/edit-product.component';


const routes: Routes = [
  { path: '', redirectTo: '/list-products', pathMatch: 'full'},
  { path: 'list-products', component: ListProductComponent },
  { path: 'add-product', component: AddProductComponent },
  { path: 'edit-product', component: EditProductComponent }
  ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
