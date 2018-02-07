package com.prowo.controller;

import com.alibaba.fastjson.JSON;
import com.prowo.bean.Result;
import com.prowo.config.KafkaTopicConfig;
import com.prowo.esper.event.DeviceEvent;
import com.prowo.kafka.KafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author prowo
 * @date 2018/2/7
 */
@RestController
@RequestMapping("/esper")
public class KafkaEsperController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private KafkaTopicConfig kafkaTopicConfig;
    @Resource
    private KafkaProducer kafkaProducer;

    @RequestMapping(value = "/request", method = {RequestMethod.POST})
    public Result queryDetail(@RequestBody DeviceEvent req) {
        kafkaProducer.sendData(kafkaTopicConfig.getMarketing(), JSON.toJSONString(req));
        return new Result();
    }

}
