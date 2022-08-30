package com.garnerju.auctionhouse.repository;

import com.garnerju.auctionhouse.models.auctionmodels.AuctionItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuctionItemsRepository extends JpaRepository<AuctionItems, Double> {
}
