/**
 * 
 */
package com.sabari.product.items.checkout.util;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 *Test class for  Check out price calculator 
 *buy n of them and it will cost only y based on special price if application
 * 
 * @author sabarirajaperiyasamy
 *
 */
public class PriceCalculationUtilTest {

	

	/**
	 * Test method for {@link com.sabari.product.items.checkout.util.PriceCalculationUtil#calculate(java.lang.Long, double, java.util.Map)}.
	 */
	@Test
	public void testCalculate() throws Exception {
		
		Map<Long , Double>  specialPriceMap = new HashMap<>();
		specialPriceMap.put(3l, 70d);// 3 item for price 70
		specialPriceMap.put(2l, 60d);// 2 item for price 60
		specialPriceMap.put(4l, 80d);// 4 item for price 80

		double totalPrice = PriceCalculationUtil.calculate(4l,50d,specialPriceMap); // Per unit Price 50 , Total item ordered = 4
		
		assertTrue (totalPrice == 80d);//Expectation is special price for 4 items needs to apply.
	}
	
	/**
	 * Test method for {@link com.sabari.product.items.checkout.util.PriceCalculationUtil#calculate(java.lang.Long, double, java.util.Map)}.
	 */
	@Test
	public void testCalculate1() throws Exception {
		
		Map<Long , Double>  specialPriceMap = new HashMap<>();
		specialPriceMap.put(2l, 60d);// 2 item for price 60
		specialPriceMap.put(4l, 80d);// 4 item for price 80

		double totalPrice = PriceCalculationUtil.calculate(7l,50d,specialPriceMap); // Per unit Price 50 , Total item ordered = 4
		/*Expection here are special for 4 item,2 item need to apply in addition to that 
		 * amount for remaining one item without special price need to be calculated.
		 * i.e,
		 *     for 4 item price is 80
		 *     for 2 item price is 60
		 *     for 1 item price is 50
		 *     
		 *     for 7 item price is 190
		 * 
		 * 
		 */
		assertTrue (totalPrice == 190d);
		
	}
	
	

}
