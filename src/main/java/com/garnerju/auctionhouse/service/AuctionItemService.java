package com.garnerju.auctionhouse.service;

import com.garnerju.auctionhouse.models.auctionmodels.AuctionItems;
import com.garnerju.auctionhouse.models.socketmodels.SocketMessage;
import com.garnerju.auctionhouse.repository.AuctionItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class AuctionItemService {

    @Autowired
    private AuctionItemsRepository  repository;

    Long newId = 0L;

    public List<AuctionItems> getAuctionItems() {
        List<AuctionItems> response = repository.findAll();
        System.out.println(response);
        return repository.findAll();
    }


    public void addAuctionItems(AuctionItems item) {

        try {
            item.setId(newId);
            repository.save(item);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void newBid(SocketMessage message) {

    }
}
