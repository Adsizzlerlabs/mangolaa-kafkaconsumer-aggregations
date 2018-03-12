package com.adsizzler.mangolaa.kafkaconsumer.aggregations.util

import java.time.ZoneId
import java.time.ZonedDateTime

/** Helper class to deal with date and time
 * Created by ankushsharma on 20/02/18.
 */
class TimeUtil {

    /**
     *
     * @return the current timestamp in UTC
     */
    static ZonedDateTime nowAsUtc(){
        ZonedDateTime.now(ZoneId.of("UTC"))
    }
}
