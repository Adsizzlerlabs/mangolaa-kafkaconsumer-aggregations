package com.adsizzler.mangolaa.kafkaconsumer.aggregations.service

import com.adsizzler.mangolaa.kafkaconsumer.aggregations.models.AbstractAggregatedEvent

/**
 * A service facade to interact with aggregated events
 * Created by ankushsharma on 20/02/18.
 */
interface AggregatedEventsService {

    /**
     *
     * @param event The event to save to db
     */
    void save(AbstractAggregatedEvent event)

}
