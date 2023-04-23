package org.example.filter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

public class ReReadableHttpServletRequest extends HttpServletRequestWrapper {

    public ReReadableHttpServletRequest(HttpServletRequest request) {
        super(request);
    }
}
