package com.adsizzler.mangolaa.kafkaconsumer.aggregations.request

import com.adsizzler.mangolaa.kafkaconsumer.aggregations.jackson.ZonedDateTimeDeserializer
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize

import java.time.ZonedDateTime

/**
 * Created by ankushsharma on 26/03/18.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
class AggregatedConversionRequest {

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

    @JsonProperty(value = "event", required = true)
    final Integer event

    @JsonProperty(value = "timestamp", required = true)
    @JsonDeserialize(using = ZonedDateTimeDeserializer)
    final ZonedDateTime timestamp

}
