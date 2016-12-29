package com.jumia.followupExercise.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Test;

import data.provider.ItemProvider;
import data.provider.OrderProvider;

public class OrderTest {

	Order order;
	Order otherOrder;

	@Test
	public void testOrder() {
		Order testOrder = null;
		assertNull(testOrder);
		testOrder = OrderProvider.buildOrder();
		assertNotNull(testOrder);
	}

	@Test
	public void testGetCustomer() {
		order = OrderProvider.buildOrder();
		assertNotNull(order.getCustomer());
	}

	@Test
	public void testSetCustomer() {
		otherOrder = OrderProvider.buildEmptyOrder();
		otherOrder.setCustomer("name", "contact", "address");
		assertEquals("name", otherOrder.getCustomer().getCustomerName());
		assertEquals("contact", otherOrder.getCustomer().getCustomerContact());
		assertEquals("address", otherOrder.getCustomer().getcustomerShippingAddress());
	}

	@Test
	public void testGetGrandTotal() {
		order= OrderProvider.buildOrder();
		assertEquals(new BigDecimal(0), order.getGrandTotal());
	}

	@Test
	public void testSetGrandTotal() {
		otherOrder = OrderProvider.buildEmptyOrder();
		otherOrder.setGrandTotal(new BigDecimal(20));
		assertEquals(0, otherOrder.getGrandTotal().compareTo(new BigDecimal(20)));
	}

	@Test
	public void testGetPurchaseDate() {
		order = OrderProvider.buildOrder();
		assertNotNull(order.getPurchaseDate().toString());
	}

	@Test
	public void testGetPurchasedProducts() {
		order = OrderProvider.buildOrder();
		assertEquals(4, order.getPurchasedProducts().size());
	}

	@Test
	public void testSetPurchasedProducts() {
		otherOrder = OrderProvider.buildEmptyOrder();
		assertEquals(0, otherOrder.getPurchasedProducts().size());
		otherOrder.setPurchasedProducts(ItemProvider.buildListItems());
		assertEquals(4, otherOrder.getPurchasedProducts().size());
	}

	@Test
	public void testAddPurchasedItemToList() {
		otherOrder = OrderProvider.buildEmptyOrder();
		assertEquals(0, otherOrder.getPurchasedProducts().size());
		Item item = ItemProvider.buildItem();
		otherOrder.addPurchasedItemToList(item);
		assertEquals(1, otherOrder.getPurchasedProducts().size());
		assertTrue(otherOrder.getPurchasedProducts().contains(item));
	}
}
