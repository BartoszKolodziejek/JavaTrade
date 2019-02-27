package kafka;

import com.google.gson.Gson;
import exception.SendingException;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import strategy.StrategyProperties;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class KafkaProducer {



    private Producer<Long, String> producer;
    private static KafkaProducer ourInstance = new KafkaProducer();
    private String topic;

    public static KafkaProducer getInstance() {
        return ourInstance;
    }

    private KafkaProducer() {
        Properties properties = StrategyProperties.getInstance().getProperties();
        Properties kafkaProperties = new Properties();
        kafkaProperties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, properties.get("kafkaBroker"));
        kafkaProperties.put(ProducerConfig.CLIENT_ID_CONFIG, properties.get("startegyName"));
        kafkaProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, Long.class.getName());
        kafkaProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, String.class.getName());
        topic = properties.getProperty("scope")+"/"+properties.getProperty("name")+"/";
        producer = new org.apache.kafka.clients.producer.KafkaProducer<Long, String>(kafkaProperties);

    }

    public RecordMetadata send(Object object, String type) throws SendingException {
        Gson gson = new Gson();
        ProducerRecord<Long, String> record = new ProducerRecord<Long, String>(topic+type, gson.toJson(object));
        try {
            return producer.send(record).get();
        } catch (InterruptedException e) {
            throw new SendingException(e.getMessage(), e.getCause());
        } catch (ExecutionException e) {
            throw new SendingException(e.getMessage(), e.getCause());
        }
    }

}
