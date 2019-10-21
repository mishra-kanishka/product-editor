package com.kanishka.productbackendboot;

import com.kanishka.productbackendboot.controller.ProductController;
import com.kanishka.productbackendboot.domain.Product;
import com.kanishka.productbackendboot.service.DetailService;
import com.kanishka.productbackendboot.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
public class ProductBackendBootApplicationTests {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private ProductService productService;

	@MockBean
	private DetailService detailService;

	@Test
	public void givenProduct_whenGetProduct_thenReturnJson() throws Exception {
		Product product = new Product("test_name", "test_catagory", 123, 12.03, Collections.emptyList());
		List<Product> allProducts = Arrays.asList(product);
		Mockito.when(productService.getAllProducts()).thenReturn(allProducts);

		mvc.perform(get("/products")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(1)))
				.andExpect(jsonPath("$[0].name", is(product.getName())));
	}

}
