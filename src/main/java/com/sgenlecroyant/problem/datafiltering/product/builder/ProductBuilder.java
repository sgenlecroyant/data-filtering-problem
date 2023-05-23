package com.sgenlecroyant.problem.datafiltering.product.builder;

import com.sgenlecroyant.problem.datafiltering.product.entity.Product;

public class ProductBuilder {

    private Long id;
    private String name;
    private double unitPrice;
    private int inStock;
    private String currency;

    public ProductBuilder(){

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

    public ProductBuilder name(String name){
        this.name= name;
        return this;
    }


    public ProductBuilder id(Long id){
        this.id = id;
        return this;
    }

    public ProductBuilder unitPrice(double unitPrice){
        this.unitPrice = unitPrice;
        return this;
    }


    public ProductBuilder inStock(int inStock){
        this.inStock = inStock;
        return this;
    }

    public ProductBuilder currency(String currency){
        this.currency = currency;
        return this;
    }

    public Product build(){
        return new Product(this);
    }

}
