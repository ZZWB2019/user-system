package com.cmpay.zwb;

import com.cmpay.lemon.common.LemonFramework;
import com.cmpay.lemon.framework.LemonBootApplication;
import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;

/**
 * @author  zhouwenbin
 */
@LemonBootApplication(exclude = {RabbitAutoConfiguration.class}, value = {"com.cmpay.zwb"})
public class ZwbApplication {
    public static void main(String[] args) {
        LemonFramework.run(ZwbApplication.class, args);
    }
}