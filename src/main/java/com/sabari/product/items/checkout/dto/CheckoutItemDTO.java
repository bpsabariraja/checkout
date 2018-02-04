/**
 * 
 */
package com.sabari.product.items.checkout.dto;

import java.io.Serializable;

/**
 * @author sabarirajaperiyasamy
 *
 */
public class CheckoutItemDTO implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7442628396294985109L;

	private String upcCode;
	
	private Long quantity;
	
	private Double unitPrice;// per unit price
	
	private Double totalPrice;// total price based on the quantity

	public String getUpcCode() {
		return upcCode;
	}

	public Long getQuantity() {
		return quantity;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setUpcCode(String upcCode) {
		this.upcCode = upcCode;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
}
