/**
 * 
 */
package com.sgenlecroyant.problem.datafiltering.strategy;

import java.util.List;

/**
 * @author sgenlecroyant
 *
 */
public interface EntityFilteringStrategy {

	public <T> List<T> filterByAnyField(String inputValue, Class<T> entityClazz);

}
