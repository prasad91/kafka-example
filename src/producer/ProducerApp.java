package producer;

import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import common.CustomObject;
import common.IKafkaConstants;

public class ProducerApp {
	public static void main(String[] args) {
		runProducer();
	}

	static void runProducer() {
		Producer<Long, CustomObject> producer = ProducerCreator.createProducer();
		for (int index = 0; index < IKafkaConstants.MESSAGE_COUNT; index++) {
			ProducerRecord<Long, CustomObject> record = new ProducerRecord<Long, CustomObject>(
					IKafkaConstants.TOPIC_NAME, new CustomObject("prasad", index));
			try {
				RecordMetadata metadata = producer.send(record).get();
				System.out.println("Record sent with key " + index + " to partition " + metadata.partition()
						+ " with offset " + metadata.offset());
			} catch (ExecutionException e) {
				System.out.println("Error in sending record");
				System.out.println(e);
			} catch (InterruptedException e) {
				System.out.println("Error in sending record");
				System.out.println(e);
			}
		}
	}
}