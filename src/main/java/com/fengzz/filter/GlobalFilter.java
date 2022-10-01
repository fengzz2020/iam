package com.fengzz.filter;

import com.fengzz.common.Constant;
import org.eclipse.jetty.util.StringUtil;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * no use
 *
 * @author Fengzz
 * @date 2022/10/1 22:10
 * <p>
 * ******* Think twice, code once. *******
 */

public class GlobalFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println(request.getRemoteAddr());
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        if (!httpServletRequest.getRequestURI().equals(Constant.USER_CREATE)) {
            validate(httpServletRequest);
        }

        chain.doFilter(request, response);
    }

    private void validate(HttpServletRequest httpServletRequest) {
        String token = httpServletRequest.getParameter("token");
        if (StringUtil.isBlank(token)) {
            throw new RuntimeException("invalid token!");
        }

    }

    @Override
    public void destroy() {

    }
}
