package com.test.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import java.util.*;

public class RestConsumer {
    public static void main(String[] args) {
        // TODO Take configuration from conf file
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("group.id", "GET-catcher");
        props.put("key.deserializer",
                "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer",
                "org.apache.kafka.common.serialization.StringDeserializer");

        KafkaConsumer<String, String> consumer = new KafkaConsumer<String,
                                String>(props);

        ArrayList<String> topicList= new ArrayList<String>();

        topicList.add("GET");
        consumer.subscribe(topicList);

        try {
            while (true) {
                // TODO Take timeout from conf file
               ConsumerRecords<String, String> records = consumer.poll(1000000000);

                for (ConsumerRecord<String, String> record : records)
                {  // TODO store in file or database
                    System.out.print("consuming");
                    //System.out.println(record.key() + " : "+record.value() );
                    System.out.println(" : "+record.value() );
                }
            }
        } finally {
            consumer.close();
        }
    }
}
