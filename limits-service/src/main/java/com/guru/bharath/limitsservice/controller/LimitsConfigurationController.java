package com.guru.bharath.limitsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guru.bharath.limitsservice.beans.LimitsConfiguaration;
import com.guru.bharath.limitsservice.configuration.Configuration;

@RestController
public class LimitsConfigurationController {

	@Autowired
	private Configuration configuration;

	@GetMapping("/limits")
	public LimitsConfiguaration retriveLimitsConfiguration() {
		return new LimitsConfiguaration(configuration.getMinimum(), configuration.getMaximum());
	}

}
