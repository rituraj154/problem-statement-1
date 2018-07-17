package com.project;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringConfiguration extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(SpringConfiguration.class, args);
	}
	
@Override
protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
	return builder.sources(SpringConfiguration.class);
}
	
	
	@Bean
	@Qualifier("levyMap")
	public Map<String,Double> getLevyMap(){
		final Map<String, Double> taxMap = new HashMap<>(3);
		taxMap.put("A", 10D);
		taxMap.put("B", 10D);
		taxMap.put("C", 0D);
		return taxMap;
	}
	

}
