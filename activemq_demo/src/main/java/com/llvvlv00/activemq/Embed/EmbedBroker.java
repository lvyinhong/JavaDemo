package com.llvvlv00.activemq.Embed;

import org.apache.activemq.broker.BrokerService;

/**
 * @author llvvlv00
 * @date 2021/03/02 1:59 下午
 * @since
 */
public class EmbedBroker {
    public static void main(String[] args) throws Exception {
        //ActiveMQ也支持在vm中通信基于嵌入式的broker
        BrokerService brokerService = new BrokerService();
        brokerService.setUseJmx(true);
        brokerService.addConnector("tcp://localhost:61616");
        brokerService.start();
    }
}
