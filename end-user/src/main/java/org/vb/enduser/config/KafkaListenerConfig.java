package org.vb.enduser.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.vb.enduser.event.LocationListenerEvent;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
public class KafkaListenerConfig {

    @Value("${spring.kafka.bootstrap-servers}")
     private String bootstrapServers;

    Logger logger = LoggerFactory.getLogger(KafkaListenerConfig.class);
//
//    @Bean
//    public Map<String, Object> consumerConfig(){
//        Map<String, Object> props = new HashMap<>();
//        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
//        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
//        props.put(ConsumerConfig.GROUP_ID_CONFIG, Constants.GROUP_ID);
//        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
//        return props;
//    }
//
//    @Bean
//    public ConsumerFactory<String, LocationListenerEvent> consumerFactory(){
//        return new DefaultKafkaConsumerFactory<>(
//            consumerConfig(),
//            new StringDeserializer(),
//            new JsonDeserializer<>()
//        );
//    }
//
//    @Bean
//    public ConcurrentKafkaListenerContainerFactory<String, LocationListenerEvent> kafkaListenerContainerFactory(){
//        ConcurrentKafkaListenerContainerFactory<String, LocationListenerEvent> factory =
//            new ConcurrentKafkaListenerContainerFactory<String, LocationListenerEvent>();
//        factory.setConsumerFactory(consumerFactory());
//        return factory;
//    }
    @KafkaListener(topics = Constants.LOCATION_TOPIC_NAME, groupId = Constants.GROUP_ID)
    public void updateLocation(String location){
        logger.info("Received Location : "+ location);
    }
}
