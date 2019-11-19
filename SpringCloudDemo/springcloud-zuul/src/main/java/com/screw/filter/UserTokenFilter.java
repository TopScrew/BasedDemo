package com.screw.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;

public class UserTokenFilter extends ZuulFilter {

    // 过滤器类型 pre 表示在 请求之前进行拦截
    public String filterType() {
        return "pre";
    }

    // 过滤器的执行顺序。当请求在一个阶段的时候存在多个多个过滤器时，需要根据该方法的返回值依次执行
    public int filterOrder() {
        return 0;  // 过滤器顺序，数字越小越先执行
    }

    // 判断过滤器是否生效
    public boolean shouldFilter() {
        return true;
    }

    //写过滤逻辑
    public Object run() throws ZuulException {
        // 获取上下文
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        String userToken = request.getParameter("userToken");
        System.out.println("1111111111!!!!!!!!!");
        if (StringUtils.isEmpty(userToken)) {
            //如果userToken为null不继续往下执行，并设置401状态码，并相应内容
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseStatusCode(401);
            currentContext.setResponseBody("userToken is null");
            return null;
        }
        // 否则正常执行业务逻辑.....
        return null;

    }
}
