package com.adsizzler.mangolaa.kafkaconsumer.aggregations.models.impl

import com.adsizzler.mangolaa.kafkaconsumer.aggregations.models.AbstractAggregatedEvent
import com.adsizzler.mangolaa.kafkaconsumer.aggregations.request.AggregatedConversionRequest
import com.adsizzler.mangolaa.kafkaconsumer.aggregations.util.Assert
import com.adsizzler.mangolaa.kafkaconsumer.aggregations.util.TimeUtil

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table
import java.time.ZonedDateTime

/**
 * Created by ankushsharma on 26/03/18.
 */
@Entity
@Table(name = "aggregated_conversions")
class AggregatedConversion extends AbstractAggregatedEvent {

    @Column(name = "campaign_id")
    Integer campaignId

    @Column(name = "creative_id")
    Integer creativeId

    @Column(name = 'event_code')
    Integer eventCode

    @Column(name = "event")
    String event

    AggregatedConversion(Map fields){
        this.timestamp = fields['timestamp'] as ZonedDateTime
        this.advId = fields['advId'] as Integer
        this.campaignId = fields['campaignId'] as Integer
        this.creativeId = fields['creativeId'] as Integer
        this.sourceId = fields['sourceId'] as Integer
        this.clientId = fields['clientId'] as Integer
        this.count = fields['count'] as Integer
        this.createdOn = fields['timestamp'] as ZonedDateTime
        this.eventCode = fields['eventCode'] as Integer
        this.event = fields['event'] as String
    }

    AggregatedConversion(AggregatedConversionRequest req){
        Assert.notNull(req, 'req cannot be null')
        this.advId = req.advId
        this.sourceId = req.sourceId
        this.clientId = req.clientId
        this.count = req.count
        this.timestamp = req.timestamp
        this.createdOn = TimeUtil.nowAsUtc()
        this.campaignId = req.campaignId
        this.creativeId = req.creativeId
        this.eventCode = req.eventCode
        this.event = req.event
    }
}
