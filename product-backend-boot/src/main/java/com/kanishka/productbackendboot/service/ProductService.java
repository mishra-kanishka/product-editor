package com.kanishka.productbackendboot.service;

import com.kanishka.productbackendboot.domain.Detail;
import com.kanishka.productbackendboot.domain.Product;
import com.kanishka.productbackendboot.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(products::add);
        return products;
    }

    public Optional<Product> getProduct(String productId) {
        return productRepository.findById(productId);
    }

    public Product addProduct(Product product) {
        List<Detail> details = new ArrayList<>();
        for (Detail detail : product.getDetails()) {
            details.add(detail);
        }
        product.setDetails(details);
        return productRepository.save(product);
    }

    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(String productId) {
        productRepository.deleteById(productId);
    }
}
