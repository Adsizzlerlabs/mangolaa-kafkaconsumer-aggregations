package com.adsizzler.mangolaa.kafkaconsumer.aggregations.jpa

import javax.persistence.AttributeConverter
import javax.persistence.Converter
import java.sql.Timestamp
import java.time.ZoneId
import java.time.ZonedDateTime

/**
 * Created by ankushsharma on 20/02/18.
 */
@Converter(autoApply = true)
class ZonedDateTimeConverter implements AttributeConverter<ZonedDateTime, Timestamp> {

    @Override
    Timestamp convertToDatabaseColumn(ZonedDateTime attribute) {
        def result
        if(attribute){
            result = Timestamp.valueOf(attribute.toLocalDateTime())
        }
        result
    }

    @Override
    ZonedDateTime convertToEntityAttribute(Timestamp dbData) {
        def result
        if(dbData){
            result = ZonedDateTime.of(dbData.toLocalDateTime(), ZoneId.of("UTC"))
        }
        result
    }
}
