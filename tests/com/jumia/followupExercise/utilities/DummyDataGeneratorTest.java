package com.jumia.followupExercise.utilities;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.jumia.followupExercise.model.Item;
import com.jumia.followupExercise.model.Order;

public class DummyDataGeneratorTest {

	int defaultItemsAmount = 20;
	int defaultOrdersAmount = 10;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGenerateDummyData() {

		List<Order> data = DummyDataGenerator.generateDummyData(2010, 2012);
		
		assertEquals(10, data.size());
		
		for(Order order : data){
			System.out.println("order date: " + order.getPurchaseDate());
			for(Item item : order.getPurchasedProducts())
				System.out.println("product:"+ item.getProduct().getCreationDate());
			System.out.println("\n");
		}
		data.sort(data.get(0));
		
		System.out.println("\n Sorting \n");
		
		for(Order order : data){
			System.out.println("order date: " + order.getPurchaseDate());
			for(Item item : order.getPurchasedProducts())
				System.out.println("product:"+ item.getProduct().getCreationDate());
			System.out.println("\n");
		}
	}

	@Test
	public void testGetAmountGeneratedOrders() {
		assertEquals(defaultOrdersAmount, DummyDataGenerator.getAmountGeneratedOrders());
	}

	@Test
	public void testSetAmountGeneratedOrders() {
		DummyDataGenerator.setAmountGeneratedOrders(30);
		assertEquals(30, DummyDataGenerator.getAmountGeneratedOrders());
	}

	@Test
	public void testGetAmountGeneratedItems() {
		assertEquals(defaultItemsAmount, DummyDataGenerator.getAmountGeneratedItems());
	}

	@Test
	public void testSetAmountGeneratedItems() {
		DummyDataGenerator.setAmountGeneratedItems(30);
		assertEquals(30, DummyDataGenerator.getAmountGeneratedItems());
	}

}
