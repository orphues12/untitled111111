package untitled.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import untitled.config.kafka.KafkaProcessor;
import untitled.domain.*;

@Service
@Transactional(rollbackFor = Exception.class)
public class PolicyHandler {

    @Autowired
    MachineRepository machineRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(
        @Payload String eventString,
        @Header(KafkaHeaders.ACKNOWLEDGMENT) Acknowledgment acknowledgment,
        @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) byte[] messageKey
    ) {
        /*
          // Call port method with received messageKey to publish msg to the same partition. //
          DomainClass.portMethod(eventString, new String(messageKey));
          
          // ,or //
          new EventRaised(domain Obj).publishAfterCommit(new String(messageKey));
          // manual Offset Commit. //
          acknowledgment.acknowledge();  
          */
    }
}