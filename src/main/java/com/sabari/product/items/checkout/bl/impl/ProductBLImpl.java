/**
 * 
 */
package com.sabari.product.items.checkout.bl.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sabari.product.items.checkout.bl.ProductBL;
import com.sabari.product.items.checkout.dto.ItemDetailsDTO;
import com.sabari.product.items.checkout.dto.ItemSpecialPriceDTO;
import com.sabari.product.items.checkout.entities.ItemDetails;
import com.sabari.product.items.checkout.entities.ItemSpecialPrice;
import com.sabari.product.items.checkout.repository.ItemDetailsRepository;
import com.sabari.product.items.checkout.repository.ItemSpecialPriceRepository;

/**
 * 
 * ProductBLImpl manages the item with  data in internal DB for the prices.
 * 
 * @author sabarirajaperiyasamy
 *
 */
@Service
public class ProductBLImpl implements ProductBL{
	
	@Autowired
	ItemDetailsRepository itemRepository;
	
	@Autowired
	ItemSpecialPriceRepository itemSplPriceRepository;
	
	@Override
	public List<ItemDetailsDTO> getAllItemDetails(){
		List<ItemDetailsDTO> dtoList = new ArrayList<>();
		List<ItemDetails> itemEnityList = itemRepository.findAll();
		if(itemEnityList!=null){
			for(ItemDetails itemDetail:itemEnityList){
				ItemDetailsDTO dto = mapToDto(itemDetail);
				if(dto!=null){
					dto.setSpecialPriceList(getSplPriceByItemId(itemDetail.getItemId()));
					dtoList.add(dto);
				}
			}
		}
		return dtoList;
		
	}
	
	@Override
	public ItemDetailsDTO getItemDetailsByUpc(String upc){
		ItemDetailsDTO dto = new ItemDetailsDTO();
		List<ItemDetails> itemEnityList = itemRepository.findByUpc(upc);
		if(itemEnityList!=null){
			ItemDetails itemDetail = itemEnityList.get(0);
			dto = mapToDto(itemDetail);
			if(dto!=null){
				dto.setSpecialPriceList(getSplPriceByItemId(itemDetail.getItemId()));
			}
		}

		return dto;
	}
	
	private ItemDetailsDTO mapToDto(ItemDetails item){
		ItemDetailsDTO itemDto = null;
		if(item!=null){
			itemDto = new ItemDetailsDTO();
			itemDto.setPrice(item.getPrice());
			itemDto.setUpcCode(item.getUpcCode());
				}
		
		return itemDto;
		
	}
	
	private List<ItemSpecialPriceDTO> getSplPriceByItemId(long itemId){
		List<ItemSpecialPriceDTO> itemSplPriceDtoList = new ArrayList<>();
		List<ItemSpecialPrice> itemSplPriceList = itemSplPriceRepository.findByItemId(itemId);
		if(itemSplPriceList!=null){
			for(ItemSpecialPrice itemPrice :itemSplPriceList ){
				if(itemPrice!=null){
					ItemSpecialPriceDTO dto = new ItemSpecialPriceDTO();
					dto.setPrice(itemPrice.getPrice());
					dto.setQuantity(itemPrice.getQuantity());
					itemSplPriceDtoList.add(dto);
				}
			}
		}
		return itemSplPriceDtoList;
	}

}
