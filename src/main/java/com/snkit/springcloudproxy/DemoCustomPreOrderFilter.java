package com.snkit.springcloudproxy;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class DemoCustomPreOrderFilter extends ZuulFilter {

	@Override
	public boolean shouldFilter() {
		HttpServletRequest httpRequest = RequestContext.getCurrentContext().getRequest();		
		String valueCust = httpRequest.getHeader("ValueCust");
		if (valueCust != null && valueCust.equals("true")) {
			return true;
		}
		return false;
	}

	@Override
	public Object run() throws ZuulException {
		System.out.println("   From DemoCustomPreOrderFilter Run method====================");
		RequestContext requestContext =  RequestContext.getCurrentContext();
		requestContext.addZuulRequestHeader("ValueCust", "BigCustomer");

		
		return null;
	}

	@Override
	public String filterType() {
		return FilterConstants.PRE_TYPE;
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 1;
	}

}
