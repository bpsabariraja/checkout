package com.sabari.product.items.checkout.dto;

import java.io.Serializable;


/**
 * @author sabarirajaperiyasamy
 *
 */
public class ItemCartDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3166542933031336574L;
	
	private String upcCode;
	
	private Long quantity;

	public String getUpcCode() {
		return upcCode;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setUpcCode(String upcCode) {
		this.upcCode = upcCode;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

}
