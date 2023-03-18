package com.garnerju.auctionhouse.controller;

import com.garnerju.auctionhouse.models.auctionmodels.AuctionItems;
import com.garnerju.auctionhouse.service.AuctionItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;



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
    public void addAuctionItem(@RequestBody AuctionItems item) {
        service.addAuctionItem(item);
    };

}
