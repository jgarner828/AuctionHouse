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
            log.info("getAuctionItems");
            return repository.findAll();
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;

        }
    }



    public void addAuctionItem(AuctionItems item) {
        try {
            log.info("addAuctionItem");
            item.setId(newId);
            repository.save(item);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }



    public SocketMessage newBid(SocketMessage message) {
        log.info("newBid");
        log.info(message.toString());

        Optional<AuctionItems> updateItem = repository.findById(message.getNewBid().getItemId());

        if(updateItem.isPresent())  {
            updateItem.get().setPrice(message.getNewBid().getBidPrice());
            repository.save(updateItem.get());
        }
        return message;
    }
}
