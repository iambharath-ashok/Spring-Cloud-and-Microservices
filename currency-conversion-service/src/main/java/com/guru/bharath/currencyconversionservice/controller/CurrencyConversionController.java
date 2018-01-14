/**
 * 
 */
package com.guru.bharath.currencyconversionservice.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.guru.bharath.currencyconversionservice.beans.CurrencyConversionBean;
import com.guru.bharath.currencyconversionservice.proxy.CurrencyConversionProxy;

/**
 * @author AB40286
 *
 */
@RestController
public class CurrencyConversionController {
	private static final Logger logger = LoggerFactory.getLogger(CurrencyConversionController.class);

	@Autowired
	private Environment environment;
	
	@Autowired
	private CurrencyConversionProxy proxy;

	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {

		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		ResponseEntity<CurrencyConversionBean> currencyConversionBeanResponseEntity = new RestTemplate()
				.getForEntity(
				"http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversionBean.class,
				uriVariables);
		CurrencyConversionBean currencyConversionBean = currencyConversionBeanResponseEntity.getBody();
		return new CurrencyConversionBean(currencyConversionBean.getId(), from, to,
				currencyConversionBean.getConversionMultiple(), quantity,
				quantity.multiply(currencyConversionBean.getConversionMultiple()),
				currencyConversionBean.getServerPort());
	}
	
	@GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrencyfeign(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {
		
		CurrencyConversionBean currencyConversionBean = proxy.retriveExchangeValue(from, to);
		logger.info("{}",currencyConversionBean);
		return new CurrencyConversionBean(currencyConversionBean.getId(), from, to,
				currencyConversionBean.getConversionMultiple(), quantity,
				quantity.multiply(currencyConversionBean.getConversionMultiple()),
				currencyConversionBean.getServerPort());
	}
}
