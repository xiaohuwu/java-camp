package org.example.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletResponseWrapper;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(urlPatterns = "/test/*")
public class CustomResponseFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        chain.doFilter(request, httpResponse);
        PrintWriter responseWriter = httpResponse.getWriter();
        responseWriter.write("\nThis line is added by the CustomResponseFilter.");
        responseWriter.close();
    }

    @Override
    public void destroy() {
    }
}

class CustomHttpServletResponseWrapper extends HttpServletResponseWrapper {
    private final StringBuilder stringBuilder = new StringBuilder();

    public CustomHttpServletResponseWrapper(HttpServletResponse response) {
        super(response);
    }

    @Override
    public PrintWriter getWriter() throws FileNotFoundException {
        return new PrintWriter(stringBuilder.toString());
    }

    @Override
    public String toString() {
        return stringBuilder.toString();
    }
}
