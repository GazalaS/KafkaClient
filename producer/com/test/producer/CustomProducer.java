package com.test.producer;

import com.test.modelgenrator.RestMessageGenerator;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class CustomProducer {

    public static void main(String[] args)   {
        // set up the producer
        KafkaProducer<String, String> producer;
        // TODO Take conf from conf file
        Properties kafkaProps = new Properties();
        kafkaProps.put("bootstrap.servers", "localhost:9092");
        kafkaProps.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
        kafkaProps.put("value.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");
        producer = new KafkaProducer<String, String>(kafkaProps);

        try {
            // TODO Take message count  from conf file
            for (int i = 0; i < 1000; i++) {

                String restMsg = RestMessageGenerator.getMessage();
                //splitting message on method type :
                String topic = restMsg.split(" ")[0];
                //String key=restMsg.split("/")[restMsg.split("/").length-1];
                // send lots of messages
                ProducerRecord<String, String> record = new ProducerRecord<String, String>(topic, restMsg);
                producer.send(record);
                System.out.println("sending message : " + restMsg + "on topic " + topic);

            }
        } catch (Throwable throwable) {
            // TODO put logger
            System.out.printf("%s", throwable.getStackTrace());
        } finally {
            producer.close();
        }

    }

}
