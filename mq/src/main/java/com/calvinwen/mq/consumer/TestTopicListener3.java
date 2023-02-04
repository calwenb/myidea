package com.calvinwen.mq.consumer;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @author calwen
 * @since 2022/12/21
 */
@Component
@RocketMQMessageListener(consumerGroup = "testConsumer2", topic = "testTopic")
public class TestTopicListener3 implements RocketMQListener<String> {

    @Override
    public void onMessage(String msg) {
        System.out.println("3 获得msg：" + msg);
    }


}