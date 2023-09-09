package com.garnerju.auctionhouse.service;

import com.garnerju.auctionhouse.models.auctionmodels.AuctionItems;
import com.garnerju.auctionhouse.models.socketmodels.SocketMessage;
import com.garnerju.auctionhouse.repository.AuctionItemsRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class AuctionItemService {

    @Autowired
    private AuctionItemsRepository  repository;

    Long newId = 0L;


    public List<AuctionItems> getAuctionItems() {
        try {
            List<AuctionItems> auctionItemsList = repository.findAll();
            System.out.println(auctionItemsList);
            return repository.findAll();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }



    public void addAuctionItem(AuctionItems item) {
        try {
            item.setId(newId);
            repository.save(item);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }



    public SocketMessage newBid(SocketMessage message) {
        System.out.println(message);
        Optional<AuctionItems> updateItem = repository.findById(message.getNewBid().getItemId());
        if(updateItem.isPresent())  {
            updateItem.get().setPrice(message.getNewBid().getBidPrice());
            repository.save(updateItem.get());
        }
        return message;
    }
}
