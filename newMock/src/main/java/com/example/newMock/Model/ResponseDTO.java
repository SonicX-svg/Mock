package com.example.newMock.Model;


import lombok.Data;

import java.math.BigDecimal;
import java.text.DecimalFormat;

@Data
public class ResponseDTO {

    private String rqUID;
    private String clientId;
    private String account;
    private String currency;
    private BigDecimal balance;
    private BigDecimal maxLimit;

}