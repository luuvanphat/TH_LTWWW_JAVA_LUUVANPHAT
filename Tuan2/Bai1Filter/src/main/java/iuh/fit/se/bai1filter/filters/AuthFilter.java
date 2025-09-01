package iuh.fit.se.bai1filter.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;

public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;

        String username = req.getParameter("username");
        if (username != null && username.equals("blocked")) {
            response.getWriter().println("<h3>Access Denied! User is blocked.</h3>");
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {}
}
