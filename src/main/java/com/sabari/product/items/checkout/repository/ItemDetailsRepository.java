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

import com.sabari.product.items.checkout.entities.ItemDetails;

/**
 * Repository contains all the item details
 * 
 * @author sabarirajaperiyasamy
 *
 */
@Repository
public class ItemDetailsRepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	class ItemDetailsRowMapper implements RowMapper<ItemDetails> {
		@Override
		public ItemDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
			ItemDetails itemDetails = new ItemDetails();
			itemDetails.setItemId(rs.getLong("itemid"));
			itemDetails.setPrice(rs.getDouble("price"));
			itemDetails.setUpcCode(rs.getString("upc"));
			
			return itemDetails;
		}

	}
	
	public List<ItemDetails> findAll() {
		return jdbcTemplate.query("select * from itemdetails", new ItemDetailsRowMapper());
	}
	
	public List<ItemDetails> findByUpc(String upcCode){
		return jdbcTemplate.query("select * from itemdetails where upc = ? ", new Object[] { upcCode },new ItemDetailsRowMapper());
	}
	

}
