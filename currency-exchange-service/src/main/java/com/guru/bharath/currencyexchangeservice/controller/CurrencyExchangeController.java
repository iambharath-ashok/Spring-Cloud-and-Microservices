/**
 * 
 */
package com.guru.bharath.currencyexchangeservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.guru.bharath.currencyexchangeservice.beans.ExchangeValue;
import com.guru.bharath.currencyexchangeservice.repository.ExchangeValueRepository;

/**
 * @author AB40286
 *
 */

@RestController
public class CurrencyExchangeController {
	private static final Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);
	@Autowired
	private Environment environment;
	
	@Autowired
	private ExchangeValueRepository exchangeValueRepository;

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retriveExchangeValue(@PathVariable String from, @PathVariable String to) {
		ExchangeValue exchangeValue =exchangeValueRepository.findByFromAndTo(from, to);
		exchangeValue.setServerPort(Integer.valueOf(environment.getProperty("local.server.port")));
		logger.info("{}",exchangeValue);
		return exchangeValue;
	}

}
