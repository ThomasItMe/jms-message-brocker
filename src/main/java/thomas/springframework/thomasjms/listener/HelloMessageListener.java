package thomas.springframework.thomasjms.listener;

import lombok.RequiredArgsConstructor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import thomas.springframework.thomasjms.config.JmsConfig;
import thomas.springframework.thomasjms.model.HellWorldMessage;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import java.util.UUID;

/**
 * @author vvthuy on 1/8/2021
 * @project thomas-jms
 */
@RequiredArgsConstructor
@Component
public class HelloMessageListener {

    private final JmsTemplate jmsTemplate;

    @JmsListener(destination = JmsConfig.MY_QUEUE)
    public void listen(@Payload HellWorldMessage hellWorldMessage,
                       @Headers MessageHeaders headers, Message message) {

        // System.out.println("I Got a message!!!!!");

        // System.out.println(hellWorldMessage);

        // throw new RuntimeException("foo");

    }

    @JmsListener(destination = JmsConfig.MY_SEND_RCV_QUEUE)
    public void listenForHello(@Payload HellWorldMessage hellWorldMessage,
                       @Headers MessageHeaders headers, Message message) throws JMSException {

        HellWorldMessage payloadMsg = HellWorldMessage
                .builder()
                .id(UUID.randomUUID())
                .message("World!!")
                .build();

        jmsTemplate.convertAndSend(message.getJMSReplyTo(), payloadMsg);

    }



}
