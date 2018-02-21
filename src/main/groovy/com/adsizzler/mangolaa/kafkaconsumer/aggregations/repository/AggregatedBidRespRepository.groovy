package com.adsizzler.mangolaa.kafkaconsumer.aggregations.repository

import com.adsizzler.mangolaa.kafkaconsumer.aggregations.models.impl.AggregatedBidResp
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Created by ankushsharma on 21/02/18.
 */
interface AggregatedBidRespRepository extends JpaRepository<AggregatedBidResp, Integer>{
}
