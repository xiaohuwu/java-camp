package com.ktb.springbootdemo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ktb.springbootdemo.model.Product;
import org.springframework.util.StringUtils;

import java.beans.PropertyEditorSupport;
import java.io.IOException;

public class ProductEditor extends PropertyEditorSupport {


    private ObjectMapper objectMapper;

    public ProductEditor(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (StringUtils.isEmpty(text)) {
            setValue(null);
        } else {
            Product prod = new Product();
            try {
                prod = objectMapper.readValue(text, Product.class);
            } catch (JsonProcessingException e) {
                throw new IllegalArgumentException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            setValue(prod);
        }
    }

}
