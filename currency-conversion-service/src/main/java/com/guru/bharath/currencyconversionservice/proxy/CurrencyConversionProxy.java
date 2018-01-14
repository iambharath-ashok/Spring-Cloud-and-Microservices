/**
 * 
 */
package com.guru.bharath.currencyconversionservice.proxy;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.guru.bharath.currencyconversionservice.beans.CurrencyConversionBean;

/**
 * @author AB40286
 *
 */
//@FeignClient(name = "currency-exchange-service", url = "localhost:8000")
//@FeignClient(name = "currency-exchange-service")
@FeignClient(name = "netflix-zuul-api-gateway-sever")
@RibbonClient(name="currency-exchange-service")
public interface CurrencyConversionProxy {

	@GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionBean retriveExchangeValue(@PathVariable("from") String from,
			@PathVariable("to") String to);

}
