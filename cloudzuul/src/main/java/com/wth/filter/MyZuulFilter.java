package com.wth.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class MyZuulFilter extends ZuulFilter {

    @Override
    public String filterType() {
        // 这个方法返回过滤器类型，
        // 可选项，pre，route ， post ，static
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        String servletPath = request.getServletPath();
        System.out.println("servletPath+ " +servletPath);

        // true : 过滤，执行run方法
        // false :不过滤，直接放行
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        System.out.println("run()........");
        return null;
    }
}
