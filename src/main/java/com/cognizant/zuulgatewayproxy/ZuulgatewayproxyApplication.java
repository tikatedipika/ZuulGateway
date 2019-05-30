package com.cognizant.zuulgatewayproxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.cognizant.zuulgatewayproxy.filters.ErrorFilter;
import com.cognizant.zuulgatewayproxy.filters.PostFilter;
import com.cognizant.zuulgatewayproxy.filters.PreFilter;
import com.cognizant.zuulgatewayproxy.filters.RouteFilter;

@SpringBootApplication
@EnableZuulProxy
public class ZuulgatewayproxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulgatewayproxyApplication.class, args);
	}
	
	@Bean
	public PreFilter prefilter() {
		return new PreFilter();
	}
	
	@Bean
	public PostFilter postfilter() {
		return new PostFilter();
	}
	
	@Bean
	public RouteFilter routefilter() {
		return new RouteFilter();
	}
	
	@Bean
	public ErrorFilter errorfilter() {
		return new ErrorFilter();
	}
}
