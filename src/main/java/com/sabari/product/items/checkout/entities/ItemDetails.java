package com.sabari.product.items.checkout.entities;
/**
 * @author sabarirajaperiyasamy
 *
 */
public class ItemDetails {

	private long itemId;
	private String upcCode;
	private double price;
	
	public long getItemId() {
		return itemId;
	}
	public void setItemId(long itemId) {
		this.itemId = itemId;
	}
	public String getUpcCode() {
		return upcCode;
	}
	public void setUpcCode(String upcCode) {
		this.upcCode = upcCode;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}
