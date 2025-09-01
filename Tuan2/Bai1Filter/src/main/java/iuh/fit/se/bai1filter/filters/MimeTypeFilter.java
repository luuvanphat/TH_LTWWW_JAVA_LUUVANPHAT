package iuh.fit.se.bai1filter.filters;

import jakarta.servlet.*;
import java.io.IOException;

public class MimeTypeFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        response.setContentType("text/html; charset=UTF-8");
        chain.doFilter(request, response);
    }
}
