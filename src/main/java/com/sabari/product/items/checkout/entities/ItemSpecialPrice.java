package com.sabari.product.items.checkout.entities;
/**
 * @author sabarirajaperiyasamy
 *
 */
public class ItemSpecialPrice {
	
	private long specialId;
	
	private Long itemId;
	
	private Long quantity;
	
	private Double price;

	public long getSpecialId() {
		return specialId;
	}

	public Long getItemId() {
		return itemId;
	}

	public Long getQuantity() {
		return quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setSpecialId(long specialId) {
		this.specialId = specialId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
