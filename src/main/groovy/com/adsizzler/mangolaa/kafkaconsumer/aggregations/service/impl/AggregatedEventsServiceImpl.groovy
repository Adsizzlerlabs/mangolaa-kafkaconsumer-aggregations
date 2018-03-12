package com.adsizzler.mangolaa.kafkaconsumer.aggregations.service.impl

import com.adsizzler.mangolaa.kafkaconsumer.aggregations.models.AbstractAggregatedEvent
import com.adsizzler.mangolaa.kafkaconsumer.aggregations.models.impl.AggregatedBidReq
import com.adsizzler.mangolaa.kafkaconsumer.aggregations.models.impl.AggregatedBidResp
import com.adsizzler.mangolaa.kafkaconsumer.aggregations.models.impl.AggregatedClick
import com.adsizzler.mangolaa.kafkaconsumer.aggregations.models.impl.AggregatedImpression
import com.adsizzler.mangolaa.kafkaconsumer.aggregations.models.impl.AggregatedWin
import com.adsizzler.mangolaa.kafkaconsumer.aggregations.repository.AggregatedBidReqRepository
import com.adsizzler.mangolaa.kafkaconsumer.aggregations.repository.AggregatedBidRespRepository
import com.adsizzler.mangolaa.kafkaconsumer.aggregations.repository.AggregatedClickRepository
import com.adsizzler.mangolaa.kafkaconsumer.aggregations.repository.AggregatedImpressionRepository
import com.adsizzler.mangolaa.kafkaconsumer.aggregations.repository.AggregatedWinRepository
import com.adsizzler.mangolaa.kafkaconsumer.aggregations.service.AggregatedEventsService
import groovy.util.logging.Slf4j
import org.springframework.stereotype.Service
import org.springframework.util.Assert

/**
 * Created by ankushsharma on 20/02/18.
 */
@Service
@Slf4j
class AggregatedEventsServiceImpl implements AggregatedEventsService {

    private final AggregatedBidReqRepository aggregatedBidReqRepository
    private final AggregatedBidRespRepository aggregatedBidRespRepository
    private final AggregatedWinRepository aggregatedWinRepository
    private final AggregatedImpressionRepository aggregatedImpressionRepository
    private final AggregatedClickRepository aggregatedClickRepository

    AggregatedEventsServiceImpl(
            AggregatedBidReqRepository aggregatedBidReqRepository,
            AggregatedBidRespRepository aggregatedBidRespRepository,
            AggregatedWinRepository aggregatedWinRepository,
            AggregatedImpressionRepository aggregatedImpressionRepository,
            AggregatedClickRepository aggregatedClickRepository
    )
    {
        this.aggregatedBidReqRepository = aggregatedBidReqRepository
        this.aggregatedBidRespRepository = aggregatedBidRespRepository
        this.aggregatedWinRepository = aggregatedWinRepository
        this.aggregatedImpressionRepository = aggregatedImpressionRepository
        this.aggregatedClickRepository = aggregatedClickRepository
    }

    @Override
    void save(AbstractAggregatedEvent event) {
        Assert.notNull(event,'event cannot be null')

        switch(event){

            case AggregatedBidReq :
                aggregatedBidReqRepository.save(event)
                break

            case AggregatedBidResp :
                aggregatedBidRespRepository.save(event)
                break

            case AggregatedWin :
                aggregatedWinRepository.save(event)
                break

            case AggregatedImpression :
                aggregatedImpressionRepository.save(event)
                break

            case AggregatedClick :
                aggregatedClickRepository.save(event)
                break

            default :
                log.warn 'This should not happen'
        }
    }
}
