package com.ktb.controller;

import org.springframework.web.HttpRequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MyHttpRequestHandler implements HttpRequestHandler {

    @Override
    public void handleRequest (HttpServletRequest request,
                               HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        writer.write("response from MyHttpRequestHandler, uri: "+request.getRequestURI());
    }
}
