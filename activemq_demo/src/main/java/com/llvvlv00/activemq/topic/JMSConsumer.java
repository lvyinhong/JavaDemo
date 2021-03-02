package com.llvvlv00.activemq.topic;

import lombok.SneakyThrows;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author llvvlv00
 * @date 2021/03/01 10:28 下午
 * @since
 */
public class JMSConsumer {

    private static final String ACTIVE_URL ="tcp://172.16.181.2:61616";
    private static final String TOPIC_NAME = "Topic-Persist";

    @SneakyThrows
    public static void main(String[] args)  {
        System.out.println("********z3");

        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVE_URL);
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.setClientID("z3");

        Session session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);

        Topic topic = session.createTopic(TOPIC_NAME);
        TopicSubscriber topicSubscriber = session.createDurableSubscriber(topic,"remark..");
        connection.start();

        Message message = topicSubscriber.receive();
        while (null!=message) {
            TextMessage textMessage = (TextMessage) message;
            System.out.println("**********收到的持久化topic"+textMessage.getText());
            message = topicSubscriber.receive();
        }

        session.close();
        connection.close();
    }
}
