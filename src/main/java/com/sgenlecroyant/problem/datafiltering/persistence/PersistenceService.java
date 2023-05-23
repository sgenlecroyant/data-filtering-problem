/**
 * 
 */
package com.sgenlecroyant.problem.datafiltering.persistence;

import java.util.List;

/**
 * @author sgen
 *
 */
public interface PersistenceService {

	public <T> List<T> performFilter(String inputValue, Class<T> entityClazz);
}
