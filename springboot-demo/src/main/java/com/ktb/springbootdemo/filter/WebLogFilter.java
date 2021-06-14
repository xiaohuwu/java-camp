package com.ktb.springbootdemo.filter;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.slf4j.MDC;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;
import org.springframework.web.util.WebUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Enumeration;
import java.util.UUID;

/**
 * @Author: xxx
 * @Description:
 * @Date: created in 13:46 2018/7/7
 */
@Component
@Slf4j
public class WebLogFilter implements Filter {


    public void destroy() {
        // Nothing to do
    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        CopyableHttpServletRequestWrapper wrappedRequest = new CopyableHttpServletRequestWrapper(
                (HttpServletRequest) request);

        ContentCachingResponseWrapper wrapperResponse = new ContentCachingResponseWrapper((HttpServletResponse)response);

        MDC.clear();
        MDC.put("trade_id", UUID.randomUUID().toString().replaceAll("-",""));
        String body = IOUtils.toString(wrappedRequest.getReader());
        log.info("\n===>{},{},{}",wrappedRequest.getRequestURI(),wrappedRequest.getMethod(), body);
        chain.doFilter(wrappedRequest, response);
//        String responseBody = getResponseBody(wrapperResponse);
//        log.info("responseBody==={}", responseBody);
    }

    public void init(FilterConfig arg0) throws ServletException {
        // Nothing to do
    }


    private String getResponseBody(ContentCachingResponseWrapper response) {
        ContentCachingResponseWrapper wrapper = WebUtils.getNativeResponse(response, ContentCachingResponseWrapper.class);
        if(wrapper != null) {
            byte[] buf = wrapper.getContentAsByteArray();
            if(buf.length > 0) {
                String payload;
                try {
                    payload = new String(buf, 0, buf.length, wrapper.getCharacterEncoding());
                } catch (UnsupportedEncodingException e) {
                    payload = "[unknown]";
                }
                return payload;
            }
        }
        return "";
    }

    private static final class CopyableHttpServletRequestWrapper extends HttpServletRequestWrapper {

        private byte[] rawData;
        private HttpServletRequest request;
        private CopyableServletInputStream servletInputStream;

        private static final class CopyableServletInputStream extends ServletInputStream {

            private InputStream stream;

            public CopyableServletInputStream(InputStream stream) {
                this.stream = stream;
            }

            @Override
            public boolean isFinished() {
                try {
                    int remainingBytes = stream.available();
                    return 0 == remainingBytes;
                } catch (IOException ex) {
                    return false;
                }
            }

            @Override
            public boolean isReady() {
                return true;
            }

            @Override
            public void setReadListener(ReadListener listener) { }

            @Override
            public int read() throws IOException {
                return stream.read();
            }
        }

        private CopyableHttpServletRequestWrapper(HttpServletRequest request) {
            super(request);
            this.request = request;
        }

        @Override
        public ServletInputStream getInputStream() throws IOException {
            copyBodyDataIfNecessary();
            return servletInputStream;
        }

        @Override
        public BufferedReader getReader() throws IOException {
            copyBodyDataIfNecessary();
            return new BufferedReader(new InputStreamReader(servletInputStream));
        }

        public void copyBodyDataIfNecessary() throws IOException {
            if(null == rawData) {
                rawData = IOUtils.toByteArray(request.getReader(), "utf-8");
                servletInputStream = new CopyableServletInputStream(new ByteArrayInputStream(rawData));
            }
        }

        public void resetStream() throws IOException {
            this.servletInputStream = new CopyableServletInputStream(new ByteArrayInputStream(rawData));
        }
    }


}
