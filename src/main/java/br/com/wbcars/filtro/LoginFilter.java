package br.com.wbcars.filtro;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter", urlPatterns = {"/home.xhtml"})
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        Object usuarioLogado = req.getSession().getAttribute("usuarioLogado");
        if (usuarioLogado == null) {
            res.sendRedirect(req.getContextPath() + "/login.xhtml");
            return;
        }
        chain.doFilter(request, response);
    }
}
