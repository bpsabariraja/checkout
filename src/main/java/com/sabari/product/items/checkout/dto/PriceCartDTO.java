/**
 * 
 */
package com.sabari.product.items.checkout.dto;

import java.util.List;

/**
 * @author sabarirajaperiyasamy
 *
 */
public class PriceCartDTO extends ItemCartDTO{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6071079707908083174L;
	
	private Double unitPrice;
	
	private List<ItemSpecialPriceDTO> specialPriceList;

	public Double getUnitPrice() {
		return unitPrice;
	}



	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}



	public List<ItemSpecialPriceDTO> getSpecialPriceList() {
		return specialPriceList;
	}



	public void setSpecialPriceList(List<ItemSpecialPriceDTO> specialPriceList) {
		this.specialPriceList = specialPriceList;
	}



}
