package com.jumia.followupExercise.runner;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.jumia.followupExercise.model.Item;
import com.jumia.followupExercise.model.Order;
import com.jumia.followupExercise.utilities.DummyDataGenerator;

/**
 * Executor of the application
 * @author teresa
 *
 */

public class Runner {

	static String errorMessage = "Please, run this program using:\n" 
			+ "java -jar orders.jar \"initial date\" \"final date\"";
	
	static LocalDateTime initialDate;
	static LocalDateTime finalDate;
	static List<Order> orders;
	
	/**
	 * The main class
	 * @param args
	 */
	public static void main(String[] args) {

		if(args.length !=2){
			System.out.println(errorMessage);
			System.exit(1);
		}

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		initialDate = LocalDateTime.parse(args[0], formatter);
		finalDate = LocalDateTime.parse(args[1], formatter);;
		checkDatesVality(initialDate,finalDate);

		int lowerBound = initialDate.getYear();
		int upperBound = finalDate.getYear();
		orders = DummyDataGenerator.generateDummyData(lowerBound-1,upperBound);
		gatherStatistics();
	}

	/**
	 * Gather the statistical information required
	 */
	private static void gatherStatistics() {
		List<Order> ordersInRange = filterOrders();
		countOrders(ordersInRange);
	}

	/**
	 * Counts orders in intervals
	 * @param ordersInRange {@link List} with {@link Order} with the creation date
	 * in the range provided.
	 */
	private static void countOrders(List<Order> ordersInRange) {
		Map<String,Integer> map = new TreeMap<>();
		initializeMap(map);
		if(!ordersInRange.isEmpty())
			sortOrdersInInterval(ordersInRange, map);	
		print(map);
	}

	/**
	 * For each order in a list of {@link Order}, and for each {@link Item} in the
	 * purchased items, identifies in which interval it must be placed
	 * @param ordersInRange {@link List} list of orders
	 * @param map {@link TreeMap} of intervals in counters.
	 */
	private static void sortOrdersInInterval(List<Order> ordersInRange, Map<String, Integer> map) {
		for(Order order : ordersInRange){
			List<Item> purchasedItems = order.getPurchasedProducts();
			for(Item item : purchasedItems){
				long diff = ChronoUnit.MONTHS.between(initialDate, 
						item.getProduct().getCreationDate());
				double tempValue = diff /3;
				if(tempValue >=0 && tempValue <= 1)
					map.compute("1-3 months: ", (k,v) -> (v == null ? 1 : v+1));
				else if(tempValue >1 && tempValue <= 2)
					map.compute("4-6 monhts: ", (k,v) -> (v == null ? 1 : v+1));
				else if(tempValue >2 && tempValue <= 4)
					map.compute("7-12 months: ", (k,v) -> (v == null ? 1 : v+1));
				else
					map.compute(">12 months: ", (k,v) -> (v == null ? 1 : v+1));
			}
		}
	}

	/**
	 * Initializes the map with the required intervals of time
	 * @param map {@link TreeMap} 
	 */
	private static void initializeMap(Map<String, Integer> map) {
		map.put("1-3 months: ", 0);
		map.put("4-6 monhts: ", 0);
		map.put("7-12 months: ", 0);
		map.put(">12 months: ", 0);
	}

	/**
	 * Prints the map in the required format
	 * @param map {@link TreeMap}
	 */
	private static void print(Map<String, Integer> map) {
		for(String key: map.keySet())
			System.out.println(key+""+map.get(key)+ " orders");
	}

	/**
	 * Filters orders in order to only use those in the defined range.
	 * @return {@link List} filtered orders
	 */
	private static List<Order> filterOrders() {
		List<Order> filteredOrders = new ArrayList<>();
		for(Order order: orders){
			if(order.getPurchaseDate().isAfter(initialDate)
					&& order.getPurchaseDate().isBefore(finalDate))
				filteredOrders.add(order);
		}
		return filteredOrders;
	}

	/**
	 * Checks if the range has the current format with the initialDate smaller
	 * than finalDate.
	 * @param initialDate {@link LocalDateTime} lower bound of date range
	 * @param finalDate {@link LocalDateTime} upper bound of date range
	 */
	private static void checkDatesVality(LocalDateTime initialDate, LocalDateTime finalDate) {
		if(initialDate.isAfter(finalDate)){
			System.out.println(errorMessage);
			System.out.println("Initial date should be smaller than final date");
			System.exit(1);
		}		
	}
}
