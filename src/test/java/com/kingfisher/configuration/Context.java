package com.kingfisher.configuration;

import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.client.RestTemplate;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.kingfisher.coreFramework.WebDriverFactory;

@Configuration
public class Context {
	
	// to load yaml properties
		@Bean
		public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
			return new PropertySourcesPlaceholderConfigurer();
		}
		
		@Bean
		public static YamlPropertySourceLoader yamlPropertySourceLoader(){
			return new YamlPropertySourceLoader();
		}
		
		@Bean
		public ObjectMapper objectMapper(){
			return new ObjectMapper();
		}
		
		@Bean
		public RestTemplate restTemplate(){
			return new RestTemplate();
		}
		
		@Bean
		public static WebDriverFactory webDriverFactory(){
			return new WebDriverFactory();
		}

}
