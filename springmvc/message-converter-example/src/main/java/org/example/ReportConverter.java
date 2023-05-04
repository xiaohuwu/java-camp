package org.example;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class ReportConverter  extends AbstractHttpMessageConverter<Report> {



    public ReportConverter() {
        super(new MediaType("text", "report"));
    }


    @Override
    protected boolean supports(Class<?> aClass) {
        return Report.class.isAssignableFrom(aClass);
    }

    @Override
    protected Report readInternal(Class<? extends Report> aClass, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        InputStream body = httpInputMessage.getBody();
        String requestBody = toString(body);
        int i = requestBody.indexOf("\n");
        if (i == -1) {
            throw new HttpMessageNotReadableException("No first line found");
        }
        String reportName = requestBody.substring(0, i).trim();
        String content = requestBody.substring(i).trim();

        Report report = new Report();
        report.setReportName(reportName);
        report.setContent(content);
        return report;
    }

    @Override
    protected void writeInternal(Report report, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {

    }
    private static String toString(InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream, "UTF-8");
        return scanner.useDelimiter("\\A").next();
    }
}
