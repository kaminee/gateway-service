package com.kim.balk.gatewayservice.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class PreRequestHeaderFilter  extends ZuulFilter{

	@Override
	public Object run() throws ZuulException {
		RequestContext ctx = RequestContext.getCurrentContext();
		ctx.addZuulRequestHeader("x-location", "India");
		return null;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

/*	The filter order must be defined for a filter. 
	Filters may have the same filter order if the precedence is not important for the filters. 
	The filter order does not need to be sequential.*/
	
	@Override
	public int filterOrder() {
		return 0;
	}

/*	There are four types of standard filters in Zuul: pre for pre-routing filtering, 
	route for routing to an origin, post for post-routing filters, and error for error handling. 
	Zuul also supports a static type for static responses. Any filter type can be created or added 
	and run by calling the method runFilters(type).*/
	
	@Override
	public String filterType() {
		return "pre";
	}

}
