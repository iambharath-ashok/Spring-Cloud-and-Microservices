/**
 * 
 */
package com.guru.bharath.currencyexchangeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guru.bharath.currencyexchangeservice.beans.ExchangeValue;

/**
 * @author AB40286
 *
 */
public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {

	public ExchangeValue findByFromAndTo(String from, String to);

}
