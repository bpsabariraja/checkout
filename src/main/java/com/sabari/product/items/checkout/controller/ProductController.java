/**
 * 
 */
package com.sabari.product.items.checkout.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sabari.product.items.checkout.bl.ProductBL;
import com.sabari.product.items.checkout.dto.ItemDetailsDTO;

/**
 * @author sabarirajaperiyasamy
 *
 */
@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductBL productBl;
	
	/**
	 * Service to fectch all the available item details from DB
	 * 
	 * @return
	 */
	@RequestMapping("/itemdetails")
    public List<ItemDetailsDTO> getItemDetails() {
        return productBl.getAllItemDetails();
    }

}
