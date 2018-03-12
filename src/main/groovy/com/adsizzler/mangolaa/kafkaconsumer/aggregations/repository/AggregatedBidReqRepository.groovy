package com.adsizzler.mangolaa.kafkaconsumer.aggregations.repository

import com.adsizzler.mangolaa.kafkaconsumer.aggregations.models.impl.AggregatedBidReq
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Created by ankushsharma on 20/02/18.
 */
interface AggregatedBidReqRepository extends JpaRepository<AggregatedBidReq, Integer> {
}
