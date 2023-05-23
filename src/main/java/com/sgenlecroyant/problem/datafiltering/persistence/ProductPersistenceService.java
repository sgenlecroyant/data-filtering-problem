/**
 * 
 */
package com.sgenlecroyant.problem.datafiltering.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgenlecroyant.problem.datafiltering.product.entity.Product;
import com.sgenlecroyant.problem.datafiltering.strategy.EntityFilteringStrategy;

/**
 * @author sgen
 *
 */
@Service
public class ProductPersistenceService implements PersistenceService {

	private final EntityFilteringStrategy entityFilteringStrategy;

	@Autowired
	public ProductPersistenceService(EntityFilteringStrategy entityFilteringStrategy) {
		this.entityFilteringStrategy = entityFilteringStrategy;
	}

	@Override
	public <T> List<T> performFilter(String inputValue, Class<T> entityClazz) {

		List<T> filteredResults = this.entityFilteringStrategy.filterByAnyField(inputValue, entityClazz);

		return filteredResults;
	}

}
