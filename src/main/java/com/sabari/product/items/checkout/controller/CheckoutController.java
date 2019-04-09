/**
 * 
 */
package com.sabari.product.items.checkout.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sabari.product.items.checkout.bl.CheckoutBL;
import com.sabari.product.items.checkout.dto.CheckoutDTO;
import com.sabari.product.items.checkout.dto.ItemCartDTO;
import com.sabari.product.items.checkout.dto.PriceCartDTO;

/**
 * @author sabarirajaperiyasamy
 *
 */
@RestController
@RequestMapping("/checkout")
public class CheckoutController {
	
	@Autowired
	CheckoutBL checkoutBl;
	
	/**
	 * 
	 * Checkout cart depends on the price and special price in DB.
	 * 
	 * cartItemList will contain only the item and its total quantity available in cart for checkout.
	 * 
	 * While using this services ensure availability of the product in the DB
	 * 
	 *
	 * 
	 * @param cartItemList
	 * @return
	 */
	@RequestMapping("/cart")
	public CheckoutDTO checkOutCart(@RequestBody List<ItemCartDTO> cartItemList){
		return checkoutBl.calculateItemPrice(cartItemList);
		
	}

	/**
	 * PriceCart will contain all the details per unit price of item and its all special prices available.
	 * 
	 *  Since all data available in the Price Cart, this service have no dependency with DB. Its act as independent module for price calculation.
	 *  
	 *  its will return the total price along with the price associated with each product based on the quantity 
	 * 
	 * @param cartItemList
	 * @return
	 */
	@RequestMapping("/pricedcart")
	public CheckoutDTO checkOutPriceCart(@RequestBody List<PriceCartDTO> cartItemList){
		return checkoutBl.calculateForPriceCartDTO(cartItemList);
		
	}
	
	

}
