package com.llvvlv00.activemq.queue;

import lombok.SneakyThrows;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author llvvlv00
 * @date 2021/03/01 8:50 下午
 * @since
 */
public class JmsConsumer02 {
    private static final String ACTIVE_URL ="tcp://172.16.181.2:61616";
    private static final String QUEUE_NAME = "queue01";

    @SneakyThrows
    public static void main(String[] args)  {
        System.out.println("********我是消费者02");

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

        //5、创建消费者
        MessageConsumer messageConsumer = session.createConsumer(queue);
        /*
        while (true) {
            TextMessage message = (TextMessage)messageConsumer.receive(4000L);
            if (null != message) {
                System.out.println("******消费者接收到消息:" + message.getText());
            }else {
                break;
            }
        }
        */

        // 通过监听的方式来消费消息 MessageConsumer messageConsumer = session.createConsumer(queue);
         messageConsumer.setMessageListener(new MessageListener() {
             @Override
             public void onMessage(Message message) {
                 if(null!= message && message instanceof TextMessage) {
                    TextMessage textMessage = (TextMessage) message;
                     try {
                         System.out.println("******** 消费者接收到消息:"+textMessage.getText());
                     } catch (JMSException e) {
                         e.printStackTrace();
                     }
                 }
             }
         });
       System.in.read();

        // 9、关闭资源
        messageConsumer.close();
        session.close();
        connection.close();
        System.out.println("********消息接收完成");
    }
}
