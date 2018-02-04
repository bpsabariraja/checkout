/**
 * 
 */
package com.sabari.product.items.checkout.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

/**
 *Price calculation util class contains the calculation logic for  check out product item price.
 *buy n of them and it will cost only y based on special price if applicable
 *
 *
 * @author sabarirajaperiyasamy
 *
 */
public class PriceCalculationUtil {
	
	/**
	 * Calculate actual price of item by applying special price.
	 * 
	 * @param quantity  item quantity added to cart
	 * @param unitPrice  per unit price
	 * @param specialPriceDetailsMap  its key value pair of no of quantity and its price. Buy n pay y rule . All the special price associated with the item.
	 * @return
	 */
	public static double calculate(Long quantity, double unitPrice, Map<Long , Double> specialPriceDetailsMap){
		
		double totalPrice = 0d;
		
		// Collect all the available special days count as array.
		Long[] specialQuantity = specialPriceDetailsMap.keySet().toArray(new Long[0]); 
		
		// Sort the days in descending order.
		Arrays.sort(specialQuantity,Collections.reverseOrder());
		
		//calculate the special price based on the quantity added to cart
		for(int i = 0 ; i<specialQuantity.length;i++){
			
				Long itemCount = specialQuantity[i];//get special day count;
				
				double specialPrice = specialPriceDetailsMap.get(itemCount); //fetch special price associate with the days from map
				
				Long noOfCountSp = quantity / itemCount;// Identify the no of times this days offer can be applier. For example How many 4 days can be in total of 10. the expectation is 2 time
				
				quantity = quantity % itemCount; // identifying the remaining quantity.
				
				if(noOfCountSp>0){
					
					double amount = noOfCountSp * specialPrice; //calculation the no of times * special price.
					totalPrice += amount;
				}
				
				//this loop will iterate until feasibility to apply special price on remaining quantity.
			}
			
		//Remaining quantity without special price
		if(quantity>0){
				double amount = quantity * unitPrice; //applying remaining quantity with per unit price.
				totalPrice += amount;
			}
		
		
		
		return totalPrice;
	}

}
