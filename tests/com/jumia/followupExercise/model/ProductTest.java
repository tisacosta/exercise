package com.jumia.followupExercise.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import data.provider.ProductProvider;

public class ProductTest {

	Product product;
	String name = "productName";
	String category = "productCategory";
	float weight = 10.0f;
	
	@Test
	public void testProduct() {
		Product testProduct = null;
		assertNull(testProduct);
		testProduct = ProductProvider.buildProduct();
		assertNotNull(testProduct);
	}

	@Test
	public void testGetName() {
		product = ProductProvider.buildProduct();
		assertEquals(name, product.getName());
	}

	@Test
	public void testSetName() {
		String otherName = "otherProductName";
		product = ProductProvider.buildEmptyProduct();
		product.setName(otherName);
		assertEquals(otherName, product.getName());
	}

	@Test
	public void testGetCategory() {
		product = ProductProvider.buildProduct();
		assertEquals(category, product.getCategory());
	}

	@Test
	public void testSetCategory() {
		String otherCategory = "otherProductCategory";
		product = ProductProvider.buildEmptyProduct();
		product.setCategory(otherCategory);
		assertEquals(otherCategory, product.getCategory());
	}

	@Test
	public void testGetWeight() {
		product = ProductProvider.buildProduct();
		assertEquals(category, product.getCategory());
	}

	@Test
	public void testSetWeight() {
		float otherWeight = 5.0f;
		product = ProductProvider.buildEmptyProduct();	
		product.setWeight(otherWeight);
		assertTrue(otherWeight == product.getWeight());
	}

	@Test
	public void testEqualsObject() throws InterruptedException {
		product = ProductProvider.buildProduct();
		Thread.sleep(10000);
		assertNotEquals(product, ProductProvider.buildProduct());
		Product copy = product;
		assertEquals(product, copy);
	}
	
}
