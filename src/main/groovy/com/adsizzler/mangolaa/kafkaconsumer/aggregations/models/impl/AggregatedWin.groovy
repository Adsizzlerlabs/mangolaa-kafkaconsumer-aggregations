package com.adsizzler.mangolaa.kafkaconsumer.aggregations.models.impl

import com.adsizzler.mangolaa.kafkaconsumer.aggregations.models.AbstractAggregatedEvent
import com.adsizzler.mangolaa.kafkaconsumer.aggregations.request.AggregatedWinRequest
import com.adsizzler.mangolaa.kafkaconsumer.aggregations.util.Assert
import com.adsizzler.mangolaa.kafkaconsumer.aggregations.util.TimeUtil
import groovy.transform.ToString

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table
import java.time.ZonedDateTime

/**
 * Created by ankushsharma on 21/02/18.
 */
@ToString(includePackage = false)
@Entity
@Table(name = 'aggregated_wins')
class AggregatedWin extends AbstractAggregatedEvent {

    @Column(name = "campaign_id")
    Integer campaignId

    @Column(name = "creative_id")
    Integer creativeId

    AggregatedWin(Map fields){
        this.timestamp = fields['timestamp'] as ZonedDateTime
        this.advId = fields['advId'] as Integer
        this.campaignId = fields['campaignId'] as Integer
        this.creativeId = fields['creativeId'] as Integer
        this.sourceId = fields['sourceId'] as Integer
        this.clientId = fields['clientId'] as Integer
        this.count = fields['count'] as Integer
        this.createdOn = fields['timestamp'] as ZonedDateTime
    }

    AggregatedWin(AggregatedWinRequest req){
        Assert.notNull(req, 'req cannot be null')
        this.advId = req.advId
        this.sourceId = req.sourceId
        this.clientId = req.clientId
        this.count = req.count
        this.timestamp = req.timestamp
        this.createdOn = TimeUtil.nowAsUtc()
        this.campaignId = req.campaignId
        this.creativeId = req.creativeId
    }


}
