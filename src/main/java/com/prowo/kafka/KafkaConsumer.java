package com.prowo.kafka;

import com.alibaba.fastjson.JSONObject;
import com.prowo.esper.event.DeviceEvent;
import com.prowo.esper.service.ComputeService;
import com.prowo.mapper.DeviceMapper;
import com.prowo.model.Device;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.listener.MessageListener;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * kafka监听器启动 自动监听是否有消息需要消费
 *
 * @author prowo
 * @date 2018/2/7
 */
@Service
public class KafkaConsumer implements MessageListener<String, String> {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private DeviceMapper deviceMapper;

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

        String deviceId = jsonObject.getString("deviceId");
        String userId = jsonObject.getString("userId");
        String ip = jsonObject.getString("ip");
        Date requestTime = jsonObject.getDate("requestTime");

        DeviceEvent event = new DeviceEvent();
        event.setDeviceId(deviceId);
        event.setIp(ip);
        event.setUserId(userId);
        event.setRequestTime(requestTime);

        ComputeService.sendDeviceEvent(event, jsonObject, deviceId);

        logger.info("==[device]jsonObj=>{}", jsonObject.toJSONString());

        Device device = new Device();
        device.setDeviceId(deviceId);
        device.setIp(ip);
        device.setUserId(userId);
        device.setLastMinuteDeviceUsersCounts(jsonObject.getInteger("lastMinuteDeviceUsersCounts"));
        device.setLastMinuteDeviceIpCounts(jsonObject.getInteger("lastMinuteDeviceIpCounts"));
        device.setLastHourDeviceUsersCounts(jsonObject.getInteger("lastHourDeviceUsersCounts"));
        device.setLastHourDeviceIpCounts(jsonObject.getInteger("lastHourDeviceIpCounts"));
        device.setLastDayDeviceUsersCounts(jsonObject.getInteger("lastDayDeviceUsersCounts"));
        device.setLastDayDeviceIpCounts(jsonObject.getInteger("lastDayDeviceIpCounts"));
        device.setLastWeekDeviceUsersCounts(jsonObject.getInteger("lastWeekDeviceUsersCounts"));
        device.setLastWeekDeviceIpCounts(jsonObject.getInteger("lastWeekDeviceIpCounts"));

        deviceMapper.insert(device);

    }

}