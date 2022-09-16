package com.garnerju.auctionhouse.service;

import com.garnerju.auctionhouse.models.auctionmodels.AuctionItems;
import com.garnerju.auctionhouse.repository.AuctionItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

public class AuctionItemService {

    @Autowired
    private AuctionItemsRepository  repository;

    public List<AuctionItems> getAuctionItems() {
        List<AuctionItems> response = repository.findAll();
        System.out.println(response);
        return repository.findAll();
    }
}
