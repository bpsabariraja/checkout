/**
 * 
 */
package com.sabari.product.items.checkout.bl;

import java.util.List;

import com.sabari.product.items.checkout.dto.CheckoutDTO;
import com.sabari.product.items.checkout.dto.ItemCartDTO;
import com.sabari.product.items.checkout.dto.PriceCartDTO;

/**
 * @author sabarirajaperiyasamy
 *
 */
public interface CheckoutBL {

	/**
	 * Calculates the item price associate with the DB price 
	 * 
	 * @param cartItemList
	 * @return
	 */
	public CheckoutDTO calculateItemPrice(List<ItemCartDTO> cartItemList);

	/**
	 * Calculate the item price based on price cart input DTO.
	 * 
	 * @param cartItemList
	 * @return
	 */
	public CheckoutDTO calculateForPriceCartDTO(List<PriceCartDTO> cartItemList);

	
}
