package com.adsizzler.mangolaa.kafkaconsumer.aggregations.repository

import com.adsizzler.mangolaa.kafkaconsumer.aggregations.BaseSpockSpec
import com.adsizzler.mangolaa.kafkaconsumer.aggregations.models.impl.AggregatedImpression
import org.springframework.beans.factory.annotation.Autowired

import java.time.ZonedDateTime

/**
 * Created by ankushsharma on 21/02/18.
 */
class AggregatedImpressionRepositorySpec extends BaseSpockSpec {

    @Autowired
    AggregatedBidRespRepository repository

    def "save instance of AggegatedImpression to db"() {

        given:
            def now = ZonedDateTime.now()
            def campaignId = 1
            def creativeId = 1
            def advId = 2
            def clientId = 3
            def count = 10
            def sourceId = 5
            def aggr = new AggregatedImpression(
                    timestamp: now,
                    campaignId: campaignId,
                    creativeId: creativeId,
                    advId: advId,
                    sourceId: sourceId,
                    clientId: clientId,
                    count: count,
                    createdOn: now
            )

        when:
            def result = repository.save(aggr)

        then:
            result.with {
                advId == advId
                campaignId == campaignId
                creativeId == creativeId
                sourceId == sourceId
                clientId == clientId
                count == count
                timestamp == now
                createdOn == now
            }
    }

    def cleanup(){
        repository.deleteAll()
    }

}