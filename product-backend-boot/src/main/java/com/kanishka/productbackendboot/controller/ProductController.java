package com.kanishka.productbackendboot.controller;

import com.kanishka.productbackendboot.domain.Product;
import com.kanishka.productbackendboot.exception.ResourceNotFoundException;
import com.kanishka.productbackendboot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable(value = "id") String productId)
            throws ResourceNotFoundException {
        Product product = productService.getProduct(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + productId));
        return ResponseEntity.ok().body(product);
    }

    @PostMapping("/products")
    public Product createProduct(@Valid @RequestBody Product product) {
        return productService.addProduct(product);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity <Product> updateProduct(@PathVariable(value = "id") String productId,
                                                      @Valid @RequestBody Product updatedProduct)
            throws ResourceNotFoundException {
        Product product = productService.getProduct(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + productId));
        return ResponseEntity.ok(productService.updateProduct(updatedProduct));
    }

    @DeleteMapping("/products/{id}")
    public Map<String, Boolean> deleteProduct(@PathVariable(value = "id") String productId)
            throws ResourceNotFoundException {
        Product product = productService.getProduct(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + productId));

        productService.deleteProduct(product.getId());
        Map <String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
