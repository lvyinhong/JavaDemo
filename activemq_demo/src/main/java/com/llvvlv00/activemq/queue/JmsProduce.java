package com.llvvlv00.activemq.queue;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author llvvlv00
 * @date 2021/03/01 8:19 下午
 * @since
 */
public class JmsProduce {
    private static final String ACTIVE_URL ="tcp://172.16.181.2:61616";
    private static final String QUEUE_NAME = "queue01";

    public static void main(String[] args) throws JMSException {
        // 1、创建连接工厂
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVE_URL);

        // 2、通过连接工厂，获得连接connection
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();

        //3、创建会话session
        // 两个参数,第一个叫事务、第二个叫签收
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        //4、创建目的地(具体是队列还是主题topic)
        Queue queue = session.createQueue(QUEUE_NAME);

        //5、创建消息的生产者
        MessageProducer messageProducer = session.createProducer(queue);

        //6、通过使用messageProducer生产3个消息发送到MQ的队列里面
        for (int i = 1; i <= 3; i++) {
            //7、创建消息
            TextMessage textMessage= session.createTextMessage("MessageListener-----"+i);
            // 加上消息属性
            textMessage.setStringProperty("c01","vip001");
            //8、 通过messageProducer发送给mq
            messageProducer.send(textMessage);


            MapMessage mapMessage = session.createMapMessage();
            mapMessage.setString("k1","我是mapMessage:"+i);
            messageProducer.send(mapMessage);
        }

        // 9、关闭资源
        messageProducer.close();
        session.close();
        connection.close();
        System.out.println("********消息发布到MQ完成");
    }
}
