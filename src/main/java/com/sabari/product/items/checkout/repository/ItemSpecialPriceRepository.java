/**
 * 
 */
package com.sabari.product.items.checkout.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sabari.product.items.checkout.entities.ItemSpecialPrice;

/**
 * Repository contains all the special price associated with the item details
 * 
 * @author sabarirajaperiyasamy
 *
 */
@Repository
public class ItemSpecialPriceRepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	class ItemSpecialPriceRowMapper implements RowMapper<ItemSpecialPrice> {
		
		@Override
		public ItemSpecialPrice mapRow(ResultSet rs, int rowNum) throws SQLException {
			ItemSpecialPrice itemSplPrice = new ItemSpecialPrice();
			itemSplPrice.setItemId(rs.getLong("itemid"));
			itemSplPrice.setPrice(rs.getDouble("price"));
			itemSplPrice.setQuantity(rs.getLong("quantity"));
			itemSplPrice.setSpecialId(rs.getLong("specialid"));
			
			return itemSplPrice;
		}

	}
	
	public List<ItemSpecialPrice> findByItemId(Long itemId){
		return jdbcTemplate.query("select * from itemspecialprice where itemid = ? ", new Object[] { itemId },new ItemSpecialPriceRowMapper());
	}


}
