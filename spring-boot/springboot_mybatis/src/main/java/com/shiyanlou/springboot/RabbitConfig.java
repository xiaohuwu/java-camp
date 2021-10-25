package com.shiyanlou.springboot;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author shiyanlou
 */
@Component
public class RabbitConfig{

    @Bean
    public Queue queueA(){
        return new Queue("queueA");
    }

    @Bean
    public Queue queueB(){
        return new Queue("queueB");
    }

    /**
     * 建立一个 fanout 模式的 Exchange
     *
     * @return
     */
    @Bean
    FanoutExchange fanoutExchange(){
        return new FanoutExchange("fanoutExchange");
    }

    /**
     * 绑定队列 A 到交换机
     *
     * @param queueA
     * @param fanoutExchange
     * @return
     */
    @Bean
    public Binding bindingQueueA(Queue queueA, FanoutExchange fanoutExchange){
        return BindingBuilder.bind(queueA).to(fanoutExchange);
    }

    /**
     * 绑定队列 A 到交换机
     *
     * @param queueB
     * @param fanoutExchange
     * @return
     */
    @Bean
    public Binding bindingQueueB(Queue queueB, FanoutExchange fanoutExchange){
        return BindingBuilder.bind(queueB).to(fanoutExchange);
    }

}
