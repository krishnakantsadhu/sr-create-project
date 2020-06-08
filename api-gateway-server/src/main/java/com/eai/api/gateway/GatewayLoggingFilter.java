package com.eai.api.gateway;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class GatewayLoggingFilter  extends ZuulFilter{
	
	private static final Logger logger = LoggerFactory.getLogger(GatewayLoggingFilter.class);

	/*
	implement logic of filter.
	 */
	@Override
	public Object run() throws ZuulException {
		
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		logger.info("Request Type --> {}, Request uri --> {}",request.getMethod(),request.getRequestURI());
		return null;
	}

	/* NOTE : whether to execute this filter or 
	  not on the base of some logic/criteria
	 
	 */
	@Override
	public boolean shouldFilter() {
		//return false;
		
		//Exceute this filter of all condition / scenario. 
		//Hence change to true
		return true;
	}

	/*
	NOTE : you can set the order of filter when you have 
	multiple filters like. Logging filter, security filter, rate limiting filter etc.
	 */
	@Override
	public int filterOrder() {
		//return 0;
		return 1;
	}
	
	/* when to execute the filter.
	 when request arrive or after request process or when error occur.
	 */

	@Override
	public String filterType() {
		
		//return null;
		//return "post";
		//return "error";
		
		return "pre";
	}

}