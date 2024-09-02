package com.example.newMock.Controller;

import com.example.newMock.Model.KafkaConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.newMock.Model.RequestDTO;
import com.example.newMock.Model.ResponseDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
//import org.apache.kafka.clients.producer.KafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.newMock.Model.KafkaService;
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

            KafkaService.processAndSend("BOBA ABOBA BUBU");

            ResponseDTO ResponseDTO = new ResponseDTO();
            ResponseDTO.setMassage("hello");

            log.info("********** RequestDTO **********" + mapper.writerWithDefaultPrettyPrinter().writeValueAsString(RequestDTO));
            log.info("********** ResponseDTO **********" + mapper.writerWithDefaultPrettyPrinter().writeValueAsString(ResponseDTO));


            return ResponseDTO;


        } catch(Exception e ){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}
