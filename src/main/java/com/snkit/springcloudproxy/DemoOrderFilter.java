package com.snkit.springcloudproxy;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;

public class DemoOrderFilter extends ZuulFilter {

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		System.out.println("   From DemoOrderFilter Run method====================");
		return null;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return FilterConstants.PRE_TYPE;
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 2;
	}

}
