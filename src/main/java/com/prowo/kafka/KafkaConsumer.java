package com.prowo.kafka;

import com.alibaba.fastjson.JSONObject;
import com.prowo.esper.event.DeviceEvent;
import com.prowo.esper.service.ComputeService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.listener.MessageListener;
import org.springframework.stereotype.Service;

/**
 * kafka监听器启动 自动监听是否有消息需要消费
 *
 * @author prowo
 * @date 2018/2/7
 */
@Service
public class KafkaConsumer implements MessageListener<String, String> {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 监听器自动执行该方法 消费消息 自动提交offset 执行业务代码 （high level api
     * 不提供offset管理，不能指定offset进行消费）
     */
    @Override
    public void onMessage(ConsumerRecord<String, String> record) {
        logger.info("=============[kafkaConsumer]开始消费=============offset={}", record.offset());

        String json = record.value();

        logger.info("-----record:{}", json);

        JSONObject jsonObject = JSONObject.parseObject(json);

        DeviceEvent event = new DeviceEvent();
        event.setDeviceId(jsonObject.getString(""));
        event.setIp(jsonObject.getString(""));
        event.setUserId(jsonObject.getString(""));
        event.setRequestTime(jsonObject.getDate(""));

        ComputeService.sendDeviceEvent(event, jsonObject, event.getDeviceId());

        logger.info("==[device]jsonObj=>{}", jsonObject.toJSONString());
    }

}