package com.ktb.springbootdemo.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyRate {
    private String currencyPair;
    private LocalDateTime dateTime;
    private BigDecimal askPrice;
    private BigDecimal bidPrice;
}
