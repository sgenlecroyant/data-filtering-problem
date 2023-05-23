package com.sgenlecroyant.problem.datafiltering;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.sgenlecroyant.problem.datafiltering.product.entity.Product;
import com.sgenlecroyant.problem.datafiltering.product.repository.ProductRepository;

/**
 * 
 * @author sgenlecroyant
 *
 */

@SpringBootApplication
public class DataFilteringProblemApplication {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	private final ProductRepository productRepository;

	@Autowired
	public DataFilteringProblemApplication(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(DataFilteringProblemApplication.class, args);
	}

	@Bean
	public CommandLineRunner getCommandLineRunner() {
		return (commandArgs) -> {

			List<Product> products = DataInitializer.init();
			List<Product> savedProducts = this.productRepository.saveAll(products);
			
			this.logger.info("Persisted products: {}", Arrays.toString(savedProducts.toArray()));
			
		};
	}
}
