/**
 * 
 */
package com.sgenlecroyant.problem.datafiltering.product.entity;

import java.io.Serializable;

import com.sgenlecroyant.problem.datafiltering.product.builder.ProductBuilder;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @author sgenlecroyant
 *
 */
@Entity(name = "Product")
@Table(name = "products")
@SuppressWarnings("serial")
public class Product implements Serializable {

	@Id
	private Long id;
	private String name;
	private double unitPrice;
	private int inStock;
	private String currency;

	/**
	 * @author sgenlecroyant
	 */
	public Product() {

	}

	public Product(String name, double unitPrice, int inStock, String currency) {
		this.name = name;
		this.unitPrice = unitPrice;
		this.inStock = inStock;
		this.setCurrency(currency);
	}

	public Product(ProductBuilder productBuilder) {
		this.id = productBuilder.getId();
		this.name = productBuilder.getName();
		this.inStock = productBuilder.getInStock();
		this.currency = productBuilder.getCurrency();
		this.unitPrice = productBuilder.getUnitPrice();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getInStock() {
		return inStock;
	}

	public void setInStock(int inStock) {
		this.inStock = inStock;
	}

	
	public String getCurrency() {
		return currency;
	}

	
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	@Override
	public String toString() {
		return String.format("Product [id=%s, name=%s, unitPrice=%s, inStock=%s, currency=%s]", id, name, unitPrice,
				inStock, currency);
	}
	
	public static ProductBuilder builder(){
		return new ProductBuilder();
	}

}
