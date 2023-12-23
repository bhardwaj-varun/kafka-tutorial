package org.vb.deliveryboy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.vb.deliveryboy.service.KafkaProducerService;

import java.util.Map;

@RestController
@RequestMapping("/location")
public class KafkaProducerController {

    @Autowired
    private KafkaProducerService kafkaProducerService;
    @GetMapping
    public ResponseEntity<?> updateLocation(){

        //for(int i=1;i<=50000; i++){
            kafkaProducerService.updateLocation("("+Math.floor(Math.random()*100)+" , "+Math.floor(Math.random()*100)+")");
        //}

        return new ResponseEntity<>(Map.of("Message", "Location updated"), HttpStatus.OK);
    }
}
