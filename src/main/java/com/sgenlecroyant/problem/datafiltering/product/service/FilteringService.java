/**
 * 
 */
package com.sgenlecroyant.problem.datafiltering.product.service;

import java.util.List;

/**
 * @author sgen
 *
 */
public interface FilteringService {

	public <T> List<T> doFilter(String inputValue);

}
