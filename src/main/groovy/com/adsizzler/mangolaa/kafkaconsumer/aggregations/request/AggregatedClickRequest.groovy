package com.adsizzler.mangolaa.kafkaconsumer.aggregations.request

import com.adsizzler.mangolaa.kafkaconsumer.aggregations.jackson.ZonedDateTimeDeserializer
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize

import java.time.ZonedDateTime

/**
 * Created by ankushsharma on 12/03/18.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
class AggregatedClickRequest {

    @JsonProperty(value = "clientId", required = true)
    final Integer clientId

    @JsonProperty(value = "sourceId", required = true)
    final Integer sourceId

    @JsonProperty(value = "advId", required = true)
    final Integer advId

    @JsonProperty(value = "campaignId", required = true)
    final Integer campaignId

    @JsonProperty(value = "creativeId", required = true)
    final Integer creativeId

    @JsonProperty(value = "count", required = true)
    final Integer count

    @JsonProperty(value = "eventCode", required = true)
    final Integer eventCode

    @JsonProperty(value = "city", required = true)
    final String city

    @JsonProperty(value = "country", required = true)
    final String country

    @JsonProperty(value = "province", required = true)
    final String province

    @JsonProperty(value = "platform", required = true)
    final String platform

    @JsonProperty(value = "carrier", required = true)
    final String carrier


    @JsonProperty(value = "timestamp", required = true)
    @JsonDeserialize(using = ZonedDateTimeDeserializer)
    final ZonedDateTime timestamp

}
