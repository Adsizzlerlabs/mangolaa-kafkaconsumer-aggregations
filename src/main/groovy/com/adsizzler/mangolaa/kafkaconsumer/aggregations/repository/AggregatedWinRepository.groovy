package com.adsizzler.mangolaa.kafkaconsumer.aggregations.repository

import com.adsizzler.mangolaa.kafkaconsumer.aggregations.models.impl.AggregatedWin
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Created by ankushsharma on 21/02/18.
 */
interface AggregatedWinRepository extends JpaRepository<AggregatedWin, Integer> {
}
