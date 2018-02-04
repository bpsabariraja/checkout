/**
 * 
 */
package com.sabari.product.items.checkout.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @author sabarirajaperiyasamy
 *
 */
public class ItemDetailsDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7894401546524876626L;
	
	private String upcCode;
	private double price;
	private List<ItemSpecialPriceDTO> specialPriceList;
	
	public String getUpcCode() {
		return upcCode;
	}
	public double getPrice() {
		return price;
	}
	public List<ItemSpecialPriceDTO> getSpecialPriceList() {
		return specialPriceList;
	}

	public void setUpcCode(String upcCode) {
		this.upcCode = upcCode;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setSpecialPriceList(List<ItemSpecialPriceDTO> specialPriceList) {
		this.specialPriceList = specialPriceList;
	}


}
