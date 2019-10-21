import {Detail} from './details.model';

export class Product {

  public id: number;
  public name: string;
  public category: string;
  public code: number;
  public price: number;
  public details: Detail[];

  constructor(id: number, name: string, category: string, code: number, price: number, details: Detail[]) {
    this.name = name;
    this.category = category;
    this.code = code;
    this.price = price;
    this.details = details;
  }

}
