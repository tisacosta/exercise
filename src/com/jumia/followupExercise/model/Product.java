package com.jumia.followupExercise.model;

import java.time.LocalDateTime;

/**
 * Defines a product available to shop.
 * @author teresa
 *
 */
public class Product {
	
	private String name;
	private String category;
	private float weight;
	private final LocalDateTime creationDate;
	
	/**
	 * Constructor of a product
	 * @param name {@link String} name of product
	 * @param category {@link String} category of product
	 * @param weight {@link Float} weight of product
	 */
	public Product(String name, String category, float weight){
		super();
		this.name = name;
		this.category = category;
		this.weight = weight;
		this.creationDate = LocalDateTime.now();
	}
	
	/**
	 * Constructor of product for random data generation purposes. 
	 * @param name {@link String} name of product
	 * @param category {@link String} category of product
	 * @param weight {@link Float} weight of product
	 * @param creation {@link LocalDateTime} creation instant
	 */
	public Product(String name, String category, float weight, LocalDateTime creation){
		super();
		this.name = name;
		this.category = category;
		this.weight = weight;
		this.creationDate = creation;
	}

	/**
	 * Gets the name of the product.
	 * @return {@link String} of name of product
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets a name to a product
	 * @param name {@link String} name of a product
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the category of a product
	 * @return {@link String} the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * Sets a category to a product
	 * @param category {@link String} category
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * Gets the weight of a product
	 * @return {@link Float} weight
	 */
	public float getWeight() {
		return weight;
	}

	/**
	 * Sets a weight to a product
	 * @param weight {@link Float} value
	 */
	public void setWeight(float weight) {
		this.weight = weight;
	}
	
	/**
	 * Gets the time of creation of a product
	 * @return {@link LocalDateTime} creation date
	 */
	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	/**
	 * 
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + Float.floatToIntBits(weight);
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
		Product other = (Product) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (creationDate == null) {
			if (other.creationDate != null)
				return false;
		} else if (!creationDate.equals(other.creationDate))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Float.floatToIntBits(weight) != Float.floatToIntBits(other.weight))
			return false;
		return true;
	}
	
	/**
	 * 
	 */
	@Override
	public String toString() {
		return "Product [name=" + name + ", category=" + category + ", weight=" + weight + ", creationDate="
				+ creationDate + "]";
	}
}
