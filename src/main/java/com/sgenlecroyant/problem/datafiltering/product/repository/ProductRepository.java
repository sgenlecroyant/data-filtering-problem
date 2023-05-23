/**
 * 
 */
package com.sgenlecroyant.problem.datafiltering.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sgenlecroyant.problem.datafiltering.product.entity.Product;

import java.util.List;

/**
 * @author sgen
 *
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
