/**
 * 
 */
package com.guru.bharath.currencyconversionservice.beans;

import java.math.BigDecimal;

/**
 * @author AB40286
 *
 */
public class CurrencyConversionBean {

	private Long id;
	private String from;
	private String to;
	private BigDecimal conversionMultiple;
	private BigDecimal amount;
	private BigDecimal totalCalculatedAmount;
	private int serverPort;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}

	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public CurrencyConversionBean() {
		super();
	}

	public CurrencyConversionBean(Long id, String from, String to, BigDecimal conversionMultiple, BigDecimal amount,
			BigDecimal totalCalculatedAmount, int serverPort) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
		this.amount = amount;
		this.totalCalculatedAmount = totalCalculatedAmount;
		this.serverPort = serverPort;
	}

	public BigDecimal getTotalCalculatedAmount() {
		return totalCalculatedAmount;
	}

	public void setTotalCalculatedAmount(BigDecimal totalCalculatedAmount) {
		this.totalCalculatedAmount = totalCalculatedAmount;
	}

	public int getServerPort() {
		return serverPort;
	}

	public void setServerPort(int serverPort) {
		this.serverPort = serverPort;
	}

}
