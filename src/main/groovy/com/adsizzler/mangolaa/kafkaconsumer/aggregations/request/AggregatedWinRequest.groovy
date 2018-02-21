package com.adsizzler.mangolaa.kafkaconsumer.aggregations.request

import com.adsizzler.mangolaa.kafkaconsumer.aggregations.jackson.ZonedDateTimeDeserializer
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize

import java.time.ZonedDateTime

/**
 * Created by ankushsharma on 21/02/18.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
class AggregatedWinRequest {

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

    @JsonProperty(value = "timestamp", required = true)
    @JsonDeserialize(using = ZonedDateTimeDeserializer)
    final ZonedDateTime timestamp

}
