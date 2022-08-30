package com.garnerju.auctionhouse.repository;

import com.garnerju.auctionhouse.models.auctionmodels.Bid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BidRepository extends JpaRepository<Bid, Double> {
}
