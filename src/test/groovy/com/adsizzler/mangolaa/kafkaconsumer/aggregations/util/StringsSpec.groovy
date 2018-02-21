package com.adsizzler.mangolaa.kafkaconsumer.aggregations.util

import com.adsizzler.mangolaa.kafkaconsumer.aggregations.BaseSpockSpec

/**
 * Created by Ankush on 15/04/17.
 */
class StringsSpec extends BaseSpockSpec {

    def "Does String have text?"(){
        when:
            def result = Strings.hasText(str)
        then:
            result == expectedResult
        where:
            str |  expectedResult
            "A" | true
            null | false
            " "  | false
            ""  | false
            " trim " | true
    }

}
