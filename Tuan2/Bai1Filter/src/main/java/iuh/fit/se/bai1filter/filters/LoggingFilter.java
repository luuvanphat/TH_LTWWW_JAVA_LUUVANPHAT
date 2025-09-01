package iuh.fit.se.bai1filter.filters;

import jakarta.servlet.*;
import java.io.IOException;
import java.util.Date;

public class LoggingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("Request received at: " + new Date());
        chain.doFilter(request, response);
        System.out.println("Response sent at: " + new Date());
    }
}
