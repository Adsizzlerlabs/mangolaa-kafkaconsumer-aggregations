package com.adsizzler.mangolaa.kafkaconsumer.aggregations.jackson

import com.adsizzler.mangolaa.kafkaconsumer.aggregations.BaseSpockSpec
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import groovy.json.JsonBuilder

import java.time.LocalDate
import java.time.LocalTime
import java.time.ZoneId
import java.time.ZonedDateTime

/**
 * Created by ankushsharma on 21/02/18.
 */
class ZonedDateTimeDeserializerSpec extends BaseSpockSpec {

    private ObjectMapper mapper
    def jsonParser
    def deserializationCtx

    def setup(){
        mapper = new ObjectMapper()
        mapper.enable(SerializationFeature.INDENT_OUTPUT)
        deserializationCtx = mapper.getDeserializationContext()
    }

    def "Test out various date values. JsonDeserializer should convert string values to their ZonedDateTime representation "(){
        given :
            def json = new JsonBuilder([dateTime: dateTimeStr ]).toPrettyString()
            jsonParser = mapper.getFactory().createParser(json)

        when :
            jsonParser.nextToken()
            jsonParser.nextToken()
            jsonParser.nextToken()

            def result = new ZonedDateTimeDeserializer().deserialize(jsonParser, deserializationCtx)


        then :
            result  == expectedResult

        where:
            dateTimeStr                     | expectedResult
            //MINUS NANOS . NANOS is set to 0
            '2018-02-21T08:02:04.000Z[UTC]' |  ZonedDateTime.of(LocalDate.of(2018,2,21),LocalTime.of(8,2,4), ZoneId.of("UTC"))
            ''                              | null
    }
}
