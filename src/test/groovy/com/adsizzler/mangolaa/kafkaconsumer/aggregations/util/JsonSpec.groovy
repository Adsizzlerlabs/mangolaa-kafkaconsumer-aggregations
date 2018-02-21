package com.adsizzler.mangolaa.kafkaconsumer.aggregations.util

import com.adsizzler.mangolaa.kafkaconsumer.aggregations.BaseSpockSpec
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Created by ankushsharma on 30/01/18.
 */
class JsonSpec extends BaseSpockSpec {



    def "Convert a proper and valid string to Json Object"(){

        given : "A json representation of a Person object"
            def json = '{\n' +
                    '  "name" : "Ankush",\n' +
                    '  "age" : 24\n' +
                    '}'
        when:
            def person = Json.toObject(json,Person)

        then:
            person.name == "Ankush"
            person.age == 24
    }


    def "Pass null object to method.Should throw IllegalArgumentException"(){

        when:
            Json.toObject("",null)

        then :
            thrown(IllegalArgumentException)
    }

    private static class Person{
        String name
        int age

        Person(
                @JsonProperty("name") String name,
                @JsonProperty("age") int age
        )
        {
            this.name = name
            this.age = age
        }
    }
}
