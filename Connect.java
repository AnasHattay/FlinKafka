import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;

import org.apache.flink.streaming.util.serialization.SimpleStringSchema;



import java.util.Properties;



public class FlinkKafkaConsumerExample {

    public static void main(String[] args) throws Exception {

        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();



        Properties properties = new Properties();

        properties.setProperty("bootstrap.servers", "localhost:9092");

        properties.setProperty("group.id", "flink-group");



        FlinkKafkaConsumer<String> consumer = new FlinkKafkaConsumer<>("topic-name", new SimpleStringSchema(), properties);

        env.addSource(consumer)

                .print();



        env.execute("Flink Kafka Consumer Example");

    }

}

