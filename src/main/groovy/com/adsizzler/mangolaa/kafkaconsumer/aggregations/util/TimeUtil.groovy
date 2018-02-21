package com.adsizzler.mangolaa.kafkaconsumer.aggregations.util

import java.time.ZoneId
import java.time.ZonedDateTime

/**
 * Created by ankushsharma on 20/02/18.
 */
class TimeUtil {

    static ZonedDateTime nowAsUtc(){
        ZonedDateTime.now(ZoneId.of("UTC"))
    }
}
