package com.adsizzler.mangolaa.kafkaconsumer.aggregations.models

import javax.persistence.Column
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.MappedSuperclass
import java.time.ZonedDateTime

/**
 * Created by ankushsharma on 20/02/18.
 */
@MappedSuperclass
class AbstractAggregatedEvent  {

    @Id
    @GeneratedValue
    Integer id

    @Column(name = 'adv_id')
    Integer advId

    @Column(name = 'source_id')
    Integer sourceId

    @Column(name = 'client_id')
    Integer clientId

    @Column(name = 'count')
    Integer count

    @Column(name = 'timestamp')
    ZonedDateTime timestamp

    @Column(name = 'created_on')
    ZonedDateTime createdOn

}
