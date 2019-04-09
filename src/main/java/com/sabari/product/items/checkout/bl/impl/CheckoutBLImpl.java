/**
 * 
 */
package com.sabari.product.items.checkout.bl.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sabari.product.items.checkout.bl.CheckoutBL;
import com.sabari.product.items.checkout.bl.ProductBL;
import com.sabari.product.items.checkout.dto.CheckoutDTO;
import com.sabari.product.items.checkout.dto.CheckoutItemDTO;
import com.sabari.product.items.checkout.dto.ItemCartDTO;
import com.sabari.product.items.checkout.dto.ItemDetailsDTO;
import com.sabari.product.items.checkout.dto.ItemSpecialPriceDTO;
import com.sabari.product.items.checkout.dto.PriceCartDTO;
import com.sabari.product.items.checkout.util.PriceCalculationUtil;

/**
 * Checkout BL reposible for processing the item cart and its associated data transaction.
 * 
 * @author sabarirajaperiyasamy
 *
 */
@Service
public class CheckoutBLImpl implements CheckoutBL{
	
	@Autowired
	ProductBL productBl;
	
	private static final String ERROR_CODE = "500";
	
	private static final String SUCCESS_CODE= "200";
	
	private static final String SUCCESS_MSG = "success";
	
	@Override
	public CheckoutDTO calculateItemPrice(List<ItemCartDTO> cartItemList){
		
		CheckoutDTO checkOutDto = new CheckoutDTO();
		double totalPrice = 0d;
		boolean isValid = true;
		try {
			List<CheckoutItemDTO> itemList = new ArrayList<>();
			if (cartItemList != null) {
				for (ItemCartDTO cartDto : cartItemList) {
					CheckoutItemDTO itemDto = checkoutItemDetails(cartDto);
					if (itemDto != null) {
						totalPrice += itemDto.getTotalPrice();
						itemList.add(itemDto);
					}else{
						isValid = false;
						break;
					}

				}
				checkOutDto.setTotalPrice(totalPrice);
			}
			checkOutDto.setItemList(itemList);
			checkOutDto.setResponseCode(SUCCESS_CODE);
			checkOutDto.setResponseMessage(SUCCESS_MSG);
			
		} catch (Exception e) {
			checkOutDto.setResponseCode(ERROR_CODE);
			checkOutDto.setResponseMessage("Server Error : " + e.toString());
		}
		
		if(!isValid){
			checkOutDto = new CheckoutDTO();

			checkOutDto.setResponseCode(ERROR_CODE);
			checkOutDto.setResponseMessage("Invalid UPC Code, Kindly check the product added");
	
		}
		
		return checkOutDto;
		
	}
	
	private CheckoutItemDTO checkoutItemDetails(ItemCartDTO cartDto){
		CheckoutItemDTO checkoutDto = null;
		if(cartDto!=null){
			checkoutDto = new CheckoutItemDTO();
			//fetch item details from the DB
			ItemDetailsDTO itemDetailsDto = productBl.getItemDetailsByUpc(cartDto.getUpcCode());
			if(itemDetailsDto!=null){
				checkoutDto.setQuantity(cartDto.getQuantity());
				checkoutDto.setUpcCode(cartDto.getUpcCode());
				checkoutDto.setUnitPrice(itemDetailsDto.getPrice());
				
				//calculate the total price by calculation util
				checkoutDto.setTotalPrice(PriceCalculationUtil.calculate(cartDto.getQuantity(), itemDetailsDto.getPrice(), specialPriceMap(itemDetailsDto.getSpecialPriceList())));

			}
		}
		
		return checkoutDto;
		
	}
	
	private CheckoutItemDTO CheckOutDetailsByPriceCart(PriceCartDTO cartDto){
		CheckoutItemDTO checkoutDto = null;
		if(cartDto!=null){
			checkoutDto = new CheckoutItemDTO();
			checkoutDto.setQuantity(cartDto.getQuantity());
			checkoutDto.setUpcCode(cartDto.getUpcCode());
			checkoutDto.setUnitPrice(cartDto.getUnitPrice());
			//calculate the total price by calculation util
			checkoutDto.setTotalPrice(PriceCalculationUtil.calculate(cartDto.getQuantity(), cartDto.getUnitPrice(), specialPriceMap(cartDto.getSpecialPriceList())));
		}
		return checkoutDto;
	}
	
	@Override
	public CheckoutDTO calculateForPriceCartDTO(List<PriceCartDTO> cartItemList){
		
		CheckoutDTO checkOutDto = new CheckoutDTO();
		double totalPrice = 0d;
		boolean isValid = true;
		try {
			List<CheckoutItemDTO> itemList = new ArrayList<>();
			if (cartItemList != null) {
				for (PriceCartDTO cartDto : cartItemList) {
					CheckoutItemDTO itemDto = CheckOutDetailsByPriceCart(cartDto);
					if (itemDto != null) {
						totalPrice += itemDto.getTotalPrice();
						itemList.add(itemDto);
					}else{
						isValid = false;
						break;
					}

				}
				checkOutDto.setTotalPrice(totalPrice);
			}
			checkOutDto.setItemList(itemList);
			checkOutDto.setResponseCode(SUCCESS_CODE);
			checkOutDto.setResponseMessage(SUCCESS_MSG);
			
		} catch (Exception e) {
			checkOutDto.setResponseCode(ERROR_CODE);
			checkOutDto.setResponseMessage("Server Error : " + e.toString());
		}
		
		if(!isValid){
			checkOutDto = new CheckoutDTO();

			checkOutDto.setResponseCode(ERROR_CODE);
			checkOutDto.setResponseMessage("Invalid UPC Code, Kindly check the product added");
	
		}
		
		return checkOutDto;
		
	}
	
	/**
	 * Map the all the Speical price by key value pair for specific item
	 * 
	 * Key --> no of days
	 * Value ---> Special Price.
	 * 
	 * @param specialPriceList
	 * @return
	 */
	private static Map<Long , Double> specialPriceMap(List<ItemSpecialPriceDTO> specialPriceList){
		Map<Long , Double>  priceMap = new HashMap<>();
		if(specialPriceList!=null){
			for(ItemSpecialPriceDTO priceDto: specialPriceList){
				if(priceDto!=null){
					priceMap.put(priceDto.getQuantity(), priceDto.getPrice());
				}
			}

		}
				
		return priceMap;
	}
	

	
	

}
