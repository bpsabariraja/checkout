/**
 * 
 */
package com.sabari.product.items.checkout.dto;

import java.util.List;

/**
 * Checkout DTO is final check out cart DTO with the total price
 * 
 * @author sabarirajaperiyasamy
 *
 */
public class CheckoutDTO extends ResponseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6527849818322282803L;
	
	//total price that need to be paid
	private double totalPrice;
	
	//item details associated with the checkout
	private List<CheckoutItemDTO> itemList;

	public double getTotalPrice() {
		return totalPrice;
	}

	public List<CheckoutItemDTO> getItemList() {
		return itemList;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public void setItemList(List<CheckoutItemDTO> itemList) {
		this.itemList = itemList;
	}
	

}
