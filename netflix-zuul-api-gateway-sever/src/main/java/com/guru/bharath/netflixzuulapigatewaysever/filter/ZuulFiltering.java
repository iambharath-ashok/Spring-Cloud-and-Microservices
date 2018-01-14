/**
 * 
 */
package com.guru.bharath.netflixzuulapigatewaysever.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 * @author AB40286
 *
 */
@Component
public class ZuulFiltering extends ZuulFilter{

	private static final Logger logger = LoggerFactory.getLogger(ZuulFiltering.class);
	
	//Real Logic needs to implement here
	// Rate Limits, Security, Logging
	@Override
	public Object run() {
		HttpServletRequest  request = RequestContext.getCurrentContext().getRequest();
		logger.info("Request -> {} Request URI -> {} ",request, request.getRequestURI());
		return null;
	}

	//Wants to filter the request or not 
	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public int filterOrder() {
		return 0;
	}

	//post, pre, error 
	@Override
	public String filterType() {
		return "pre";
	}

	
	
}
