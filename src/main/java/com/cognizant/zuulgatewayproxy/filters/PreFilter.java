package com.cognizant.zuulgatewayproxy.filters;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class PreFilter extends ZuulFilter {

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext ctx = RequestContext.getCurrentContext();
	    HttpServletRequest request = ctx.getRequest();
	    //;
	    Enumeration<String> headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String name = headerNames.nextElement();
			System.out.println("header name:"+name);
			Enumeration<String> values = request.getHeaders(name);

			while (values.hasMoreElements()) {
				String value = values.nextElement();
				System.out.println("Header Value"+value);
			}
		}
	    System.out.println("Request Method : " + request.getMethod() + " Request URL : " + request.getRequestURL().toString());
	    return null;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "pre";
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 1;
	}

}
