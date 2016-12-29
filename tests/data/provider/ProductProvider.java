package data.provider;

import com.jumia.followupExercise.model.Product;
import com.jumia.followupExercise.utilities.RandomDateGenerator;

/**
 * Class that generates products
 * For testing purposes
 * @author teresa
 *
 */
public class ProductProvider {
	
	/**
	 * Builds a product
	 * @return {@link Product}
	 */
	public static Product buildProduct(){
		String name = "productName";
		String category = "productCategory";
		float weight = 10.0f;
		return new Product(name, category, weight, 
				RandomDateGenerator.getRandomDateBetween(2014, 2016));
	}
	
	/**
	 * Builds an empty product
	 * @return {@link Product}
	 */
	public static Product buildEmptyProduct(){
		return new Product("", "", 0.0f);
	}

}
