/**
 * 
 */
package com.sabari.product.items.checkout.bl;

import java.util.List;

import com.sabari.product.items.checkout.dto.ItemDetailsDTO;

/**
 * @author sabarirajaperiyasamy
 *
 */
public interface ProductBL {

	/**
	 * Fetch all the item details available in DB
	 * @return
	 */
	public List<ItemDetailsDTO> getAllItemDetails();

	/**
	 * Fetch item based on the item upc code
	 * 
	 * @param upc
	 * @return
	 */
	public ItemDetailsDTO getItemDetailsByUpc(String upc);

}
