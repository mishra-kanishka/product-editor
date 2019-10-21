package com.kanishka.productbackendboot.repository;

import com.kanishka.productbackendboot.domain.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, String> {

}
