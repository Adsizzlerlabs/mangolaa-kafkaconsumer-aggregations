package com.adsizzler.mangolaa.kafkaconsumer.aggregations.jpa

import com.adsizzler.mangolaa.kafkaconsumer.aggregations.BaseSpockSpec

import java.sql.Timestamp
import java.time.ZoneId
import java.time.ZonedDateTime

/**
 * Created by ankushsharma on 21/02/18.
 */
class ZonedDateTimeConverterSpec extends BaseSpockSpec {

    def "ZonedDateTime -> sql.Timestamp conv test"(){

        given :
            def now = ZonedDateTime.now() // Zone doesn't matter

        when :
            def timestamp = new ZonedDateTimeConverter().convertToDatabaseColumn(now)

        then :
            timestamp == Timestamp.valueOf(now.toLocalDateTime())
    }

    def "sql.Timestamp -> ZonedDateTime conv test"(){

        given :
            def now = ZonedDateTime.now(ZoneId.of("UTC"))
            def timestamp = Timestamp.valueOf(now.toLocalDateTime())

        when :
            def zonedDateTime = new ZonedDateTimeConverter().convertToEntityAttribute(timestamp)

        then :
            zonedDateTime == now

    }

}
