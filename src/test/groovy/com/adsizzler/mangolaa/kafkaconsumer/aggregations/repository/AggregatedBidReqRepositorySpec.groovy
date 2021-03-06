package com.adsizzler.mangolaa.kafkaconsumer.aggregations.repository

import com.adsizzler.mangolaa.kafkaconsumer.aggregations.BaseSpockSpec
import com.adsizzler.mangolaa.kafkaconsumer.aggregations.models.impl.AggregatedBidReq
import org.springframework.beans.factory.annotation.Autowired

import java.time.ZonedDateTime

/**
 * Created by ankushsharma on 21/02/18.
 */
class AggregatedBidReqRepositorySpec extends BaseSpockSpec {

    @Autowired
    AggregatedBidReqRepository repository

    def "save instance of AggegatedBidReq to db"(){
        given :
            def now = ZonedDateTime.now()
            def advId = 2
            def clientId = 3
            def count = 10
            def sourceId = 5
            def aggr = new AggregatedBidReq(
                    timestamp : now,
                    advId : advId,
                    sourceId : sourceId,
                    clientId : clientId,
                    count : count,
                    createdOn : now
            )

        when :
            def result = repository.save(aggr)

        then :
            result.with {
                advId == advId
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
