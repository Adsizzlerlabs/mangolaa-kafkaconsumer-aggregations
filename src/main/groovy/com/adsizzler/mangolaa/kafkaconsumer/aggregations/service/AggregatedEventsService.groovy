package com.adsizzler.mangolaa.kafkaconsumer.aggregations.service

import com.adsizzler.mangolaa.kafkaconsumer.aggregations.models.AbstractAggregatedEvent

/**
 * Created by ankushsharma on 20/02/18.
 */
interface AggregatedEventsService {

    void save(AbstractAggregatedEvent event)

}
