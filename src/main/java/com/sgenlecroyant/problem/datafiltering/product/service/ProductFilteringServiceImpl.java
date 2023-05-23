/**
 * 
 */
package com.sgenlecroyant.problem.datafiltering.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgenlecroyant.problem.datafiltering.persistence.PersistenceService;
import com.sgenlecroyant.problem.datafiltering.product.entity.Product;

/**
 * @author sgen
 *
 */
@Service
public class ProductFilteringServiceImpl implements FilteringService {

	private final PersistenceService persistenceService;

	@Autowired
	public ProductFilteringServiceImpl(PersistenceService persistenceService) {
		this.persistenceService = persistenceService;
	}

	@Override
	public List<? extends Object> doFilter(String inputValue) {
		List<Product> filteredProducts = this.persistenceService.performFilter(inputValue, Product.class);
		return filteredProducts;
	}

}
