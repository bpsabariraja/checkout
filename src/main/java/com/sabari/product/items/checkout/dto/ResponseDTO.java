/**
 * 
 */
package com.sabari.product.items.checkout.dto;

import java.io.Serializable;

/**
 * @author sabarirajaperiyasamy
 *
 */
public class ResponseDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1872102181496636324L;
	
	private String responseCode;
	
	private String responseMessage;

	public String getResponseCode() {
		return responseCode;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

}
