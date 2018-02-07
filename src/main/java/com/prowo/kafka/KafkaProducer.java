package com.prowo.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class KafkaProducer implements InitializingBean {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendData(String topic, String data) {
        logger.info("---send to kafka topic={},data={}", topic, data);
        kafkaTemplate.send(topic, data);
    }

    @Override
    public void afterPropertiesSet() {
        //建立producer与kafka的联系
        kafkaTemplate.sendDefault(new Date().toString());
    }

}
