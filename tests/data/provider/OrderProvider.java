package data.provider;

import java.util.ArrayList;
import java.util.List;

import com.jumia.followupExercise.model.Item;
import com.jumia.followupExercise.model.Order;

/**
 * Class that generates an order
 * For testing purposes
 * @author teresa
 *
 */
public class OrderProvider {
	
	static String name = "Customer Name";
	static String contact = "Customer Contact";
	static String address = "Send my stuff to this address";
	
	/**
	 * Builds an order
	 * @return {@link Order}
	 */
	public static Order buildOrder(){
		List<Item> items = ItemProvider.buildListItems();
		return new Order(name, contact, address, items);
	}

	/**
	 * Builds an empty order
	 * @return {@link Order}
	 */
	public static Order buildEmptyOrder(){
		return new Order("", "","", new ArrayList<>());
	}
}
