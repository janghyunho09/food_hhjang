package foodjang.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import foodjang.config.kafka.KafkaProcessor;
import foodjang.domain.*;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PolicyHandler {

    @Autowired
    DeliveryRepository deliveryRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='CookStarted'"
    )
    public void wheneverCookStarted_LoadDeliveryImform(
        @Payload CookStarted cookStarted
    ) {
        CookStarted event = cookStarted;
        System.out.println(
            "\n\n##### listener LoadDeliveryImform : " + cookStarted + "\n\n"
        );

        // Sample Logic //
        Delivery.loadDeliveryImform(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Orderplaced'"
    )
    public void wheneverOrderplaced_LoadDeliveryImform(
        @Payload Orderplaced orderplaced
    ) {
        Orderplaced event = orderplaced;
        System.out.println(
            "\n\n##### listener LoadDeliveryImform : " + orderplaced + "\n\n"
        );

        // Sample Logic //
        Delivery.loadDeliveryImform(event);
    }
}
