package com.adsizzler.mangolaa.kafkaconsumer.aggregations.jackson

import com.adsizzler.mangolaa.kafkaconsumer.aggregations.util.Strings
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer

import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

/**
 * Created by ankushsharma on 20/02/18.
 */
class ZonedDateTimeDeserializer extends JsonDeserializer<ZonedDateTime> {

    @Override
    ZonedDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        def text = p.text
        def result
        if(Strings.hasText(text)){
            result = ZonedDateTime.parse(
                    text,
                    DateTimeFormatter.ISO_ZONED_DATE_TIME
            )
        }
        result
    }

}
