package com.darksci.kafkaview.manager.kafka;

import com.darksci.kafkaview.manager.kafka.dto.PartitionDetails;
import com.darksci.kafkaview.manager.kafka.dto.TopicDetails;
import com.darksci.kafkaview.manager.kafka.dto.TopicList;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.PartitionInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class KafkaOperations {
    private final static Logger logger = LoggerFactory.getLogger(KafkaOperations.class);
    private final static long TIMEOUT = 5000L;

    private final KafkaConsumer kafkaConsumer;

    public KafkaOperations(final KafkaConsumer kafkaConsumer) {
        this.kafkaConsumer = kafkaConsumer;
    }

    public TopicList getAvailableTopics() {
        final Map<String, List<PartitionInfo>> allTopics = kafkaConsumer.listTopics();

        final List<TopicDetails> topicDetails = new ArrayList<>();

        // Loop over
        for (final Map.Entry<String, List<PartitionInfo>> entry: allTopics.entrySet()) {
            final String topicName = entry.getKey();
            final List<PartitionInfo> partitionInfos = entry.getValue();

            // Loop over each partition
            final List<PartitionDetails> partitionDetails = new ArrayList<>();
            for (final PartitionInfo partitionInfo: partitionInfos) {
                partitionDetails.add(new PartitionDetails(partitionInfo.topic(), partitionInfo.partition()));
            }
            topicDetails.add(new TopicDetails(topicName, partitionDetails));
        }

        return new TopicList(topicDetails);
    }

}
