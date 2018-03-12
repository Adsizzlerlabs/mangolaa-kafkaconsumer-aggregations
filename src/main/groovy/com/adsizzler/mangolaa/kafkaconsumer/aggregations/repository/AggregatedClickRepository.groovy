package com.adsizzler.mangolaa.kafkaconsumer.aggregations.repository

import com.adsizzler.mangolaa.kafkaconsumer.aggregations.models.impl.AggregatedClick
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Created by ankushsharma on 12/03/18.
 */
interface AggregatedClickRepository extends JpaRepository<AggregatedClick, Integer> {
}
