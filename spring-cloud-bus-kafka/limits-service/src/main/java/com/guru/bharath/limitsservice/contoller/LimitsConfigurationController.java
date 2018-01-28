/**
 * 
 */
package com.guru.bharath.limitsservice.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guru.bharath.limitsservice.bean.LimitsConfiguration;
import com.guru.bharath.limitsservice.config.Configuration;

/**
 * @author AB40286
 *
 */

@RestController
public class LimitsConfigurationController {
	
	@Autowired
	private Configuration configuration;
	
	@GetMapping("/limits")
	public LimitsConfiguration retreiveLimitsConfiguration() {
		return new LimitsConfiguration(configuration.getMinimum(),configuration.getMaximum());
	}

}
