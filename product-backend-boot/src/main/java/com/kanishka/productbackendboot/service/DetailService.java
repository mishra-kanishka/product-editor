package com.kanishka.productbackendboot.service;

import com.kanishka.productbackendboot.domain.Detail;
import com.kanishka.productbackendboot.domain.Product;
import com.kanishka.productbackendboot.repository.DetailsRepository;
import com.kanishka.productbackendboot.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DetailService {

    @Autowired
    private DetailsRepository detailsRepository;
    @Autowired
    private ProductRepository productRepository;

    public List<Detail> getAllProductDetails(String productId) {
        return new ArrayList<>(detailsRepository.findByProductId(productId));
    }

    public Optional<Detail> getDetail(String id) {
        return detailsRepository.findById(id);
    }

    public Product addDetail(String productId, Detail detail) {
        Product product = productRepository.findById(productId).orElse(null);
        if (product != null) {
            List<Detail> details = product.getDetails();
            details.add(detail);
            product.setDetails(details);
            productRepository.save(product);
        }
        return product;
    }

    public Detail updateDetail(Detail detail) {
        return detailsRepository.save(detail);
    }

    public void deleteDetail(String id) {
        detailsRepository.deleteById(id);
    }
}
