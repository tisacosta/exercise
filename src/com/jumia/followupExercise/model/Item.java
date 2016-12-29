package com.jumia.followupExercise.model;

import java.math.BigDecimal;

/**
 * Class that represents an Item.
 * @author teresa
 *
 */
public class Item{
	
	private BigDecimal cost;
	private BigDecimal shippingFee;
	private BigDecimal taxAmount;
	private Product product;
	
	/**
	 * Item constructor
	 * @param cost {@link BigDecimal} value of the cost of the item
	 * @param shippingFee {@link BigDecimal} value of the shipping fee
	 * @param taxAmount {@link BigDecimal} value of tax amount
	 * @param product {@link Product} associated to the item
	 */
	public Item(BigDecimal cost, BigDecimal shippingFee, 
			BigDecimal taxAmount, Product product){
		super();
		this.cost = cost;
		this.shippingFee = shippingFee;
		this.taxAmount = taxAmount;
		this.product = product;
	}

	/**
	 * Gets the product of the current item 
	 * @return {@link Product} of the current item
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * Defines a product to an item
	 * @param product {@link Product} to be assigned to the item
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	/**
	 * Gets the item cost
	 * @return {@link BigDecimal} cost of the item
	 */
	public BigDecimal getCost() {
		return cost;
	}

	/**
	 * Defines the cost of an item
	 * @param cost {@link BigDecimal} value of the cost of an item
	 */
	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}
	
	/**
	 * Gets the shipping fee of an item
	 * @return {@link BigDecimal} value of shipping fee
	 */
	public BigDecimal getShippingFee() {
		return shippingFee;
	}

	/**
	 * Defines the shipping fee value
	 * @param shippingFee {@link BigDecimal} value of the fee
	 */
	public void setShippingFee(BigDecimal shippingFee) {
		this.shippingFee = shippingFee;
	}

	/**
	 * Gets the tax amount of an item
	 * @return {@link BigDecimal} value of tax amount
	 */
	public BigDecimal getTaxAmount() {
		return taxAmount;
	}

	/**
	 * Defines a new tax value 
	 * @param taxAmount {@link BigDecimal} value of the tax
	 */
	public void setTaxAmount(BigDecimal taxAmount) {
		this.taxAmount = taxAmount;
	}

	/**
	 * 
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cost == null) ? 0 : cost.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + ((shippingFee == null) ? 0 : shippingFee.hashCode());
		result = prime * result + ((taxAmount == null) ? 0 : taxAmount.hashCode());
		return result;
	}

	/**
	 * 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (cost == null) {
			if (other.cost != null)
				return false;
		} else if (!cost.equals(other.cost))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (shippingFee == null) {
			if (other.shippingFee != null)
				return false;
		} else if (!shippingFee.equals(other.shippingFee))
			return false;
		if (taxAmount == null) {
			if (other.taxAmount != null)
				return false;
		} else if (!taxAmount.equals(other.taxAmount))
			return false;
		return true;
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		return "Item [cost=" + cost + ", shippingFee=" + shippingFee + ", taxAmount=" + taxAmount + ", product="
				+ product + "]";
	}
}
