/**
 * 
 */
package com.sgenlecroyant.problem.datafiltering.product.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sgenlecroyant.problem.datafiltering.product.service.FilteringService;

/**
 * @author sgen
 *
 */
@RestController
public class ProductController {

	private final FilteringService filteringService;

	@Autowired
	public ProductController(FilteringService filteringService) {
		this.filteringService = filteringService;
	}

	@GetMapping(path = "/products")
	public ResponseEntity<Collection<Object>> filterByAnyField(@RequestParam String filter) {
		List<Object> response = this.filteringService.doFilter(filter);
		return ResponseEntity.ok(response);
	}

}
