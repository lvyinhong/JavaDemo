package com.llvvlv00.activemq.topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author llvvlv00
 * @date 2021/03/01 10:28 下午
 * @since
 */
public class JMSProduce {
    private static final String ACTIVE_URL ="tcp://172.16.181.2:61616";
    private static final String TOPIC_NAME = "Topic-Persist";

    public static void main(String[] args) throws JMSException {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVE_URL);
        Connection connection = activeMQConnectionFactory.createConnection();
        Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
        Topic topic = session.createTopic(TOPIC_NAME);
        MessageProducer messageProducer = session.createProducer(topic);
        messageProducer.setDeliveryMode(DeliveryMode.PERSISTENT);
        connection.start();

        try {
            for (int i = 1; i <= 3; i++) {
                //7、创建消息
                TextMessage textMessage= session.createTextMessage("msg-persist-----"+i);
                //8、 通过messageProducer发送给mq
                messageProducer.send(textMessage);
            }
//            session.commit();
            // ok session,commit
        }catch (Exception e){
            session.rollback();
            // error
        }finally {
            messageProducer.close();
            session.close();
            connection.close();
        }
    }
}
