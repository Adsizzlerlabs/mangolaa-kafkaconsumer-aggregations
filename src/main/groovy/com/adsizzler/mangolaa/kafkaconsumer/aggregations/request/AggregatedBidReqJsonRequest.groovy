package com.adsizzler.mangolaa.kafkaconsumer.aggregations.request

import com.adsizzler.mangolaa.kafkaconsumer.aggregations.jackson.ZonedDateTimeDeserializer
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize

import java.time.ZonedDateTime

/**
 * Created by ankushsharma on 20/02/18.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
class AggregatedBidReqJsonRequest {

    @JsonProperty(value = "clientId", required = true)
    final Integer clientId

    @JsonProperty(value = "sourceId", required = true)
    final Integer sourceId

    @JsonProperty(value = "advId", required = true)
    final Integer advId

    @JsonProperty(value = "count", required = true)
    final Integer count

    @JsonProperty(value = "timestamp", required = true)
    @JsonDeserialize(using = ZonedDateTimeDeserializer)
    final ZonedDateTime timestamp

}
