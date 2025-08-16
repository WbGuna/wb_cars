package br.com.wbcars.filtro;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HttpsRedirectFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        if (!req.isSecure()) {
            String url = "https://" + req.getServerName() + req.getRequestURI();
            if (req.getQueryString() != null) {
                url += "?" + req.getQueryString();
            }
            res.sendRedirect(url);
            return;
        }
        chain.doFilter(request, response);
    }
    @Override
    public void init(FilterConfig filterConfig) {}
    @Override
    public void destroy() {}
}
