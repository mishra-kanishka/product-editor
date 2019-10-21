package com.kanishka.productbackendboot.service;

import com.kanishka.productbackendboot.domain.Product;
import com.kanishka.productbackendboot.repository.ProductRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
public class ProductServiceTest {
    private static final String PRODUCT_ID = "100";

    @TestConfiguration
    static class ProductServiceTestContextConfiguration {

        @Bean
        public ProductService productService() {
            return new ProductService();
        }
    }

    @Autowired
    private ProductService productService;

    @MockBean
    private ProductRepository productRepository;

    @Before
    public void setUp() {
        Product product = new Product();
        product.setId(PRODUCT_ID);
        Mockito.when(productRepository.findById(PRODUCT_ID)).thenReturn(Optional.of(product));
    }

    @Test
    public void whenValidId_thenProductShouldBeFound() {
        Product product = productService.getProduct(PRODUCT_ID).orElse(null);
        assertNotNull(product);
        assertEquals(product.getId(), PRODUCT_ID);
    }

}
