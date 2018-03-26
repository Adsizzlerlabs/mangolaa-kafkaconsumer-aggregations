package com.adsizzler.mangolaa.kafkaconsumer.aggregations.models.impl

import com.adsizzler.mangolaa.kafkaconsumer.aggregations.models.AbstractAggregatedEvent
import com.adsizzler.mangolaa.kafkaconsumer.aggregations.request.AggregatedClickRequest
import com.adsizzler.mangolaa.kafkaconsumer.aggregations.util.Assert
import com.adsizzler.mangolaa.kafkaconsumer.aggregations.util.TimeUtil

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table
import java.time.ZonedDateTime

/**
 * Created by ankushsharma on 12/03/18.
 */
@Entity
@Table(name = "aggregated_clicks")
class AggregatedClick extends  AbstractAggregatedEvent {

    @Column(name = "campaign_id")
    Integer campaignId

    @Column(name = "creative_id")
    Integer creativeId

    @Column(name = 'event_code')
    Integer eventCode

    @Column(name = "city")
    String city

    @Column(name = "country")
    String country

    @Column(name = "province")
    String province

    @Column(name = "platform")
    String platform

    @Column(name = "carrier")
    String carrier

    AggregatedClick(Map fields){
        this.timestamp = fields['timestamp'] as ZonedDateTime
        this.advId = fields['advId'] as Integer
        this.campaignId = fields['campaignId'] as Integer
        this.creativeId = fields['creativeId'] as Integer
        this.sourceId = fields['sourceId'] as Integer
        this.clientId = fields['clientId'] as Integer
        this.count = fields['count'] as Integer
        this.createdOn = fields['timestamp'] as ZonedDateTime
        this.eventCode = fields['eventCode'] as Integer
        this.city = fields['city'] as String
        this.country = fields['country'] as String
        this.province = fields['province'] as String
        this.platform = fields['platform'] as String
        this.carrier = fields['carrier'] as String
    }

    AggregatedClick(AggregatedClickRequest req){
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
        this.city = req.city
        this.country = req.country
        this.province = req.province
        this.platform = req.platform
        this.carrier = req.carrier
    }

}
