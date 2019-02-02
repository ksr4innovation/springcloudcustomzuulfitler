According to the sample, our class needs to extend the ZuulFilter class. This is the base class for every Zuul filters we want to create. ZuulFilter is an abstract class and we need to implement the following methods:
• filterType() should return one of the following values:
• "pre" filters are used to set up data in the RequestContext to be used by route filters.
• "route" filters are run after pre filters and are used to make requests to other services.
• "post" filters typically manipulate the response.
• filterOrder() sets the precedence order of a filter,
depending on its importance
• shouldFilter() determines whether a run method should be invoked
run() the core method of a filter. In our case, we get the current request context and add a new header to the request made to a microservice.
========================================

Can add custom headers to Zuul RequestContext as below and backing service getting such a request can look for the header.

RequestContext requestContext =  RequestContext.getCurrentContext();
requestContext.addZuulRequestHeader("ValueCust", "BigCustomer");
