package org.vb.deliveryboy.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.vb.deliveryboy.config.Constants;
import org.vb.deliveryboy.event.LocationUpdatedEvent;

@Service
public class KafkaProducerService {


    @Autowired
    private KafkaTemplate<String, LocationUpdatedEvent> kafkaTemplate;

    Logger logger = LoggerFactory.getLogger(KafkaProducerService.class);

    public void updateLocation(String location){
        kafkaTemplate.send(Constants.LOCATION_TOPIC_NAME, new LocationUpdatedEvent(location));
    }

}
