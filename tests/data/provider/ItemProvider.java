package data.provider;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import com.jumia.followupExercise.model.Item;
import com.jumia.followupExercise.model.Product;

/**
 * Class that generates items.
 * Used for testing purposes
 * @author teresa
 *
 */
public class ItemProvider {
	
	/**
	 * Builds a dummy item
	 * @return {@link Item}
	 */
	public static Item buildItem(){
		BigDecimal cost = new BigDecimal(39);
		BigDecimal shippingFee= new BigDecimal(39);
		BigDecimal taxAmount= new BigDecimal(39);
		Product product= ProductProvider.buildProduct();
		Item item = new Item(cost, shippingFee, taxAmount, product);
		return item;
	}
	
	/**
	 * Builds an empty item.
	 * @return {@link Item}
	 */
	public static Item buildEmptyItem(){
		BigDecimal cost = null;
		BigDecimal shippingFee= null;
		BigDecimal taxAmount= null;
		Product product= null;
		Item item = new Item(cost, shippingFee, taxAmount, product);
		return item;
	}

	/**
	 * Builds a list of items
	 * @return {@link List} of {@link Item}
	 */
	public static List<Item> buildListItems(){
		return Arrays.asList(
				ItemProvider.buildItem(),
				ItemProvider.buildItem(),
				ItemProvider.buildItem(),
				ItemProvider.buildItem()
				);
	}
}
