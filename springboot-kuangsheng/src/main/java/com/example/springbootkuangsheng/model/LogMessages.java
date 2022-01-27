package com.example.springbootkuangsheng.model;

public class LogMessages {

    int status;
    String method;
    String requestURI;
    String remoteAddr;
    String toString;
    String responsePayload;

    public LogMessages() {

    }

    public void setHttpStatus(int status) {
        this.status = status;
    }

    public void setHttpMethod(String method) {
        this.method = method;

    }

    public void setPath(String requestURI) {
        this.requestURI = requestURI;

    }

    public void setClientIp(String remoteAddr) {

        this.remoteAddr = remoteAddr;
    }

    public void setJavaMethod(String toString) {
        this.toString = toString;
    }

    public void setResponse(String responsePayload) {
        this.responsePayload = responsePayload;

    }

    @Override
    public String toString() {
        return "LogMessages{" +
                "status=" + status +
                ", method='" + method + '\'' +
                ", requestURI='" + requestURI + '\'' +
                ", remoteAddr='" + remoteAddr + '\'' +
                ", toString='" + toString + '\'' +
                ", responsePayload='" + responsePayload + '\'' +
                '}';
    }
}
