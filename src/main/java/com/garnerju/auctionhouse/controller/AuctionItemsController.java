package com.garnerju.auctionhouse.controller;

import com.garnerju.auctionhouse.models.auctionmodels.AuctionItems;
import com.garnerju.auctionhouse.service.AuctionItemService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Log4j2
@RestController
public class AuctionItemsController {

    @Autowired
    private AuctionItemService service;

    @GetMapping("/auctionlist")
    @ResponseStatus(HttpStatus.OK)
    public List<AuctionItems> getAuctionItems() {
        return service.getAuctionItems();
    }

    @PostMapping("/auctionlist")
    @ResponseStatus(HttpStatus.CREATED)
    public void addAuctionItems(@RequestBody AuctionItems item) {
        service.addAuctionItems(item);
    };

}
