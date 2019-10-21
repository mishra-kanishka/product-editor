package com.kanishka.productbackendboot.controller;

import com.kanishka.productbackendboot.domain.Detail;
import com.kanishka.productbackendboot.domain.Product;
import com.kanishka.productbackendboot.exception.ResourceNotFoundException;
import com.kanishka.productbackendboot.service.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class DetailController {

    @Autowired
    private DetailService detailService;

    @GetMapping("/products/{id}/details")
    public List<Detail> getAllDetails(@PathVariable(value = "id") String productId) {
        return detailService.getAllProductDetails(productId);
    }

    @GetMapping("/products/{productId}/details/{id}")
    public ResponseEntity<Detail> getDetail(@PathVariable(value = "id") String id)
            throws ResourceNotFoundException {
        Detail detail = detailService.getDetail(id)
                .orElseThrow(() -> new ResourceNotFoundException("Detail not found for this id :: " + id));
        return ResponseEntity.ok().body(detail);
    }

    @PostMapping("/products/{productId}/details")
    public Product createDetails(@Valid @RequestBody Detail detail,
                                 @PathVariable(value = "productId") String productId) {
        return detailService.addDetail(productId, detail);
    }

    @PutMapping("/products/{productId}/details/{id}")
    public ResponseEntity <Detail> updateProduct(@PathVariable(value = "productId") String productId,
                                                 @Valid @RequestBody Detail detail,
                                                 @PathVariable(value = "id") String id)
            throws ResourceNotFoundException {
        Detail productDetail = detailService.getDetail(id)
                .orElseThrow(() -> new ResourceNotFoundException("Detail not found for this id :: " + id));
        return ResponseEntity.ok(detailService.updateDetail(detail));
    }

    @DeleteMapping("/products/{productId}/details/{id}")
    public Map<String, Boolean> deleteProduct(@PathVariable(value = "id") String id)
            throws ResourceNotFoundException {
        Detail detail = detailService.getDetail(id)
                .orElseThrow(() -> new ResourceNotFoundException("Detail not found for this id :: " + id));

        detailService.deleteDetail(id);
        Map <String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
