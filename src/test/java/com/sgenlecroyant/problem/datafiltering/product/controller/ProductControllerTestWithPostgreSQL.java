/**
 * 
 */
package com.sgenlecroyant.problem.datafiltering.product.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.sgenlecroyant.problem.datafiltering.product.entity.Product;
import com.sgenlecroyant.problem.datafiltering.product.repository.ProductRepository;
import com.sgenlecroyant.problem.datafiltering.product.service.FilteringService;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author sgenlecroyant
 *
 */
@SpringBootTest
@ActiveProfiles("postgres")
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class ProductControllerTestWithPostgreSQL {

	
	private static final String BASE_URL = "/products";
	private static final String FILTER_PARAM = "filter";

    @Autowired
    private JacksonTester<Collection<Object>> collectionTester;


    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();

    }

    @Test
    void testFilterByAnyField() throws Exception {

        //persisted products
        String value  = "sam";

        Product samsung = Product.builder()
                .id(1L)
                .name("Samsung")
                .currency("$")
                .inStock(300)
                .unitPrice(2000D)
                .build();

        Product iPhone = Product.builder()
                .id(2L)
                .name("iPhone 12 Pro")
                .inStock(30)
                .currency("$")
                .unitPrice(8000D)
                .build();

        Product huawei = Product.builder()
                .id(3L)
                .name("Huawei Honor")
                .unitPrice(7500D)
                .inStock(40)
                .currency("$")
                .build();


        this.mockMvc.perform(MockMvcRequestBuilders.get(BASE_URL, value).param(FILTER_PARAM, value))
                .andExpect(status().isOk())
                .andExpect((result -> System.out.println(result.getResponse().getContentAsString())));
    }

}
