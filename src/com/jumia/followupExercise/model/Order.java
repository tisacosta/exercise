package com.jumia.followupExercise.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * This class represents an order
 * An order is performed by a {@link Customer}.
 * Each {@link Order} can have several {@link Item} purchased.
 * @author teresa
 *
 */
public class Order implements Comparator<Order>{

	/**
	 * Class that defines a customer.
	 * @author teresa
	 *
	 */
	class Customer {
		private String customerName;
		private String customerContact;
		private String customerShippingAddress;
	
		/**
		 * Constructor of customer
		 * @param name {@link String} customer's name
		 * @param contact {@link String} customer's contact
		 * @param address {@link String} shipping address
		 */
		public Customer(String name, String contact, String address) {
			this.customerName = name;
			this.customerContact = contact;
			this.customerShippingAddress = address;
		}
		
		/**
		 * Gets the customer's name
		 * @return {@link String} customer's name
		 */
		public String getCustomerName() {
			return customerName;
		}
		
		/**
		 * Sets the customer's name
		 * @param customerName {@link String} customer's name
		 */
		public void setCustomerName(String customerName) {
			this.customerName = customerName;
		}
		
		/**
		 * Gets the customer's contact
		 * @return	{@link String} customer's contact
		 */
		public String getCustomerContact() {
			return customerContact;
		}

		/**
		 * Defines customer's contact
		 * @param customerContact {@link String} customer's contact
		 */
		public void setCustomerContact(String customerContact) {
			this.customerContact = customerContact;
		}

		/**
		 * Gets the shipping address
		 * @return {@link String} shipping address
		 */
		public String getcustomerShippingAddress() {
			return customerShippingAddress;
		}
		
		/**
		 * Sets a shipping address
		 * @param shippingAddress {@link String} shipping address
		 */
		public void setcustomerShippingAddress(String shippingAddress) {
			this.customerShippingAddress = shippingAddress;
		}

		/**
		 * 
		 */
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((customerContact == null) ? 0 : customerContact.hashCode());
			result = prime * result + ((customerName == null) ? 0 : customerName.hashCode());
			result = prime * result + ((customerShippingAddress == null) ? 0 : customerShippingAddress.hashCode());
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
			Customer other = (Customer) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (customerContact == null) {
				if (other.customerContact != null)
					return false;
			} else if (!customerContact.equals(other.customerContact))
				return false;
			if (customerName == null) {
				if (other.customerName != null)
					return false;
			} else if (!customerName.equals(other.customerName))
				return false;
			if (customerShippingAddress == null) {
				if (other.customerShippingAddress != null)
					return false;
			} else if (!customerShippingAddress.equals(other.customerShippingAddress))
				return false;
			return true;
		}
		
		/**
		 * 
		 * @return
		 */
		private Order getOuterType() {
			return Order.this;
		}
		
	}
	
	private Customer customer;
	private BigDecimal grandTotal;
	private final LocalDateTime purchaseDate;
	List<Item> purchasedItems = new ArrayList<>();
	
	/**
	 * Constructor of new {@link Order}
	 * @param customer	{@link Customer} customer that does the order
	 * @param items	{@link List} items purchased
	 */
	public Order(Customer customer, List<Item> items){
		super();
		this.customer= customer;
		this.purchasedItems = items;
		this.purchaseDate = LocalDateTime.now();
		this.grandTotal = calculateTotal(items);
	}
	
	/**
	 * Constructor of a new {@link Order} for random data generation purposes.
	 * @param customer {@link Customer} that performs the order
	 * @param items	{@link List} items purchased
	 * @param creation {@link LocalDateTime} instant of order creation
	 */
	public Order(Customer customer, List<Item> items, LocalDateTime creation){
		super();
		this.customer= customer;
		this.purchasedItems = items;
		this.purchaseDate = creation;
		this.grandTotal = calculateTotal(items);
	}
	
	/**
	 * Constructor of {@link Order}.
	 * @param name	{@link String} customer's name
	 * @param contact {@link String} customer's contact
	 * @param address {@link String} shipping address
	 * @param items {@link List} items purchased
	 */
	public Order(String name, String contact, String address,
			List<Item> items){
		super();
		this.customer = new Customer(name, contact, address);
		this.purchasedItems = items;
		this.purchaseDate = LocalDateTime.now();
		this.grandTotal = calculateTotal(items);
	}
	
	/**
	 * Constructor of a new {@link Order} for random data generation purposes.
	 * @param name	{@link String} customer's name
	 * @param contact {@link String} customer's contact
	 * @param address {@link String} shipping address
	 * @param items {@link List} items purchased
	 * @param creation {@link LocalDateTime} instant of order creation
	 */
	public Order(String name, String contact, String address,
			List<Item> items, LocalDateTime creation){
		super();
		this.customer = new Customer(name, contact, address);
		this.purchasedItems = items;
		this.purchaseDate = creation;
		this.grandTotal = calculateTotal(items);
	}
	
	/**
	 * Gets the customer of the order
	 * @return {@link Customer} customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * Creates a new customer and associates it to the order
	 * @param name	{@link String} customer's name
	 * @param contact {@link String} customer's contact
	 * @param address {@link String} shipping address
	 */
	public void setCustomer(String name, String contact, String address) {
		this.customer = new Customer(name, contact, address);
	}

	/**
	 * Gets the total value of the order
	 * @return {@link BigDecimal} order value
	 */
	public BigDecimal getGrandTotal() {
		return grandTotal;
	}
	
	/**
	 * Setns the total value of the order
	 * @param grandTotal {@link BigDecimal} order value
	 */
	public void setGrandTotal(BigDecimal grandTotal) {
		this.grandTotal = grandTotal;
	}

	/**
	 * Gets the date of the order
	 * @return {@link LocalDateTime} creation date of order
	 */
	public LocalDateTime getPurchaseDate() {
		return purchaseDate;
	}

	/**
	 * Gets a list of purchased items
	 * @return {@link List} of purchased items
	 */
	public List<Item> getPurchasedProducts() {
		return purchasedItems;
	}

	/**
	 * Sets a list of purchased items
	 * @param purchasedProducts {@link List} of purchased items
	 */
	public void setPurchasedProducts(List<Item> purchasedProducts) {
		this.purchasedItems = purchasedProducts;
	}
	
	/**
	 * Adds a new item to the purchased list and updates the grand total value
	 * @param item {@link Item} new item
	 */
	public void addPurchasedItemToList(Item item){
		this.purchasedItems.add(item);
		this.grandTotal = calculateTotal(purchasedItems);
	}

	/**
	 * Calculates the total value of the items purchased
	 * @param items {@link List} of items purchased
	 * @return {@link BigDecimal} value of the grand total
	 */
	private BigDecimal calculateTotal(List<Item> items) {
		//TODO implement method that calculates the total value of the
		//purchased order
		return new BigDecimal(0);
	}

	/**
	 * Compares two different orders by their creation dates
	 */
	@Override
	public int compare(Order o1, Order o2) {
		return o1.getPurchaseDate().compareTo(o2.getPurchaseDate());
	}
}
