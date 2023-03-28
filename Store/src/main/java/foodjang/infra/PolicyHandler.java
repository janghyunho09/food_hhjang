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
    CookRepository cookRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Orderplaced'"
    )
    public void wheneverOrderplaced_LoadOrderImfiorm(
        @Payload Orderplaced orderplaced
    ) {
        Orderplaced event = orderplaced;
        System.out.println(
            "\n\n##### listener LoadOrderImfiorm : " + orderplaced + "\n\n"
        );

        // Sample Logic //
        Cook.loadOrderImfiorm(event);
    }
}
