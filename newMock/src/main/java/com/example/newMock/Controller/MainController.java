package com.example.newMock.Controller;


import com.example.newMock.Model.RequestDTO;
import com.example.newMock.Model.ResponseDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.math.BigDecimal;

@RestController
public class MainController {
    private Logger log = LoggerFactory.getLogger(MainController.class);

    ObjectMapper mapper = new ObjectMapper();

    @PostMapping(
            value = "/info/postBalances",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Object postBalances(@RequestBody  RequestDTO RequestDTO){
        try {
            String clientId = RequestDTO.getClientId();
            char firstDigit = clientId.charAt(0);
            BigDecimal maxlimit;
            String RqUID = RequestDTO.getRqUID();

            if (firstDigit == '8') {
                maxlimit = new BigDecimal(2000);
            } else if (firstDigit == '9') {
                maxlimit = new BigDecimal(1000);
            } else {
                maxlimit = new BigDecimal(10000);
            }


            ResponseDTO ResponseDTO = new ResponseDTO();

            ResponseDTO.setRqUID(RqUID);
            ResponseDTO.setClientId(clientId);
            ResponseDTO.setAccount(RequestDTO.getAccount());
            ResponseDTO.setCurrency("RU");
            ResponseDTO.setBalance(new BigDecimal(777));
            ResponseDTO.setMaxLimit(maxlimit);

            log.error("********** RequestDTO **********" + mapper.writerWithDefaultPrettyPrinter().writeValueAsString(RequestDTO));
            log.error("********** ResponseDTO **********" + mapper.writerWithDefaultPrettyPrinter().writeValueAsString(ResponseDTO));


            return ResponseDTO;


        } catch(Exception e ){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}
