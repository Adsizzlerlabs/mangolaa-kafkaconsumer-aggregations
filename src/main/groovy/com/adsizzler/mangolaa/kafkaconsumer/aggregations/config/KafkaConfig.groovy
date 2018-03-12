package com.adsizzler.mangolaa.kafkaconsumer.aggregations.config

import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.serialization.ByteArrayDeserializer
import org.apache.kafka.common.serialization.StringDeserializer
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory

/**
 * Created by Ankush on 03/02/17.
 */
@Configuration
class KafkaConfig {

    @Value("\${kafka.bootstrap.servers}")
    private String bootstrapServers

    @Bean
     Map<String, Object> consumerConfigs() {
        def props = [:]
        // list of host:port pairs used for establishing the initial connections
        // to the Kakfa cluster
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers)
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer)
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, ByteArrayDeserializer)
        // consumer groups allow a pool of processes to divide the work of
        // consuming and processing records
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "mangolaa-aggregations-group")
        return props
    }

    @Bean
     ConsumerFactory<Integer, String> consumerFactory() {
         new DefaultKafkaConsumerFactory<>(consumerConfigs())
    }

    @Bean
     ConcurrentKafkaListenerContainerFactory<Integer, String> kafkaListenerContainerFactory() {
        def factory = new ConcurrentKafkaListenerContainerFactory<>()
        factory.setConsumerFactory(consumerFactory())
        factory
    }

}
