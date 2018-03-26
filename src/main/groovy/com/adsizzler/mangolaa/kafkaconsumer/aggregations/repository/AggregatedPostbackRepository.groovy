package com.adsizzler.mangolaa.kafkaconsumer.aggregations.repository

import com.adsizzler.mangolaa.kafkaconsumer.aggregations.models.impl.AggregatedPostback
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Created by ankushsharma on 26/03/18.
 */
interface AggregatedPostbackRepository extends JpaRepository<AggregatedPostback, Integer> {
}
