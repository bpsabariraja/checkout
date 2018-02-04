/**
 * 
 */
package com.sabari.product.items.checkout.dto;

import java.io.Serializable;

/**
 * @author sabarirajaperiyasamy
 *
 */
public class ItemSpecialPriceDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4466753642789980537L;

	
	private Long quantity;
	
	private Double price;

	
	public Long getQuantity() {
		return quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
