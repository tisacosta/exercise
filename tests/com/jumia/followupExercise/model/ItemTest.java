package com.jumia.followupExercise.model;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import data.provider.ItemProvider;
import data.provider.ProductProvider;

public class ItemTest {
	
	Item item;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testItem() {
		Item testitem=null;
		assertNull(testitem);
		testitem = ItemProvider.buildItem();
		assertNotNull(testitem);
	}

	@Test
	public void testGetProduct() {
		item = ItemProvider.buildEmptyItem();
		Product product = ProductProvider.buildProduct();
		item.setProduct(product);
		assertEquals(product, item.getProduct());
	}

	@Test
	public void testSetProduct() {
		item = ItemProvider.buildEmptyItem();
		assertNull(item.getProduct());
		Product product = ProductProvider.buildProduct();
		item.setProduct(product);
		assertNotNull(item.getProduct());
	}

	@Test
	public void testGetCost() {
		item = ItemProvider.buildItem();
		assertEquals(new BigDecimal(39), item.getCost());
	}

	@Test
	public void testSetCost() {
		BigDecimal cost = new BigDecimal(10);
		item = ItemProvider.buildEmptyItem();
		assertNull(item.getCost());
		item.setCost(cost);
		assertEquals(cost, item.getCost());
	}

	@Test
	public void testGetShippingFee() {
		item = ItemProvider.buildItem();
		assertEquals(new BigDecimal(39), item.getShippingFee());
	}

	@Test
	public void testSetShippingFee() {
		BigDecimal fee = new BigDecimal(10);
		item = ItemProvider.buildEmptyItem();
		assertNull(item.getShippingFee());
		item.setShippingFee(fee);
		assertEquals(fee, item.getShippingFee());
	}

	@Test
	public void testGetTaxAmount() {
		item = ItemProvider.buildItem();
		assertEquals(new BigDecimal(39),item.getTaxAmount());
	}

	@Test
	public void testSetTaxAmount() {
		BigDecimal newTax = new BigDecimal(0.10);
		item = ItemProvider.buildEmptyItem();
		assertNull(item.getTaxAmount());
		item.setTaxAmount(newTax);
		assertEquals(0, item.getTaxAmount().compareTo(newTax));
		
	}
	
	@Test
	public void testEqualsObject() throws InterruptedException{
		item = ItemProvider.buildItem();
		Thread.sleep(1000);
		assertNotEquals(item, ItemProvider.buildItem());
		Item otherItem = item;
		assertEquals(item, otherItem);
	}

}
