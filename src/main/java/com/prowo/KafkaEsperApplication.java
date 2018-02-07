package com.prowo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @author prowo
 * @date 2018/2/7
 */
@SpringBootApplication(scanBasePackages = "com.prowo")
@ImportResource("spring/applicationContext.xml")
public class KafkaEsperApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaEsperApplication.class, args);
    }

}
