package com.prowo.kafka;

import com.alibaba.fastjson.JSON;
import com.prowo.esper.event.DeviceEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
        DeviceEvent event = new DeviceEvent();
        event.setUserId("test");
        event.setIp("127.0.0.1");
        event.setDeviceId("test");
        event.setRequestTime(System.currentTimeMillis());
        event.setBeforeDayTime(System.currentTimeMillis());
        event.setBeforeHourTime(System.currentTimeMillis());
        event.setBeforeMinuteTime(System.currentTimeMillis());
        event.setBeforeWeekTime(System.currentTimeMillis());
        kafkaTemplate.sendDefault(JSON.toJSONString(event));
    }

}
