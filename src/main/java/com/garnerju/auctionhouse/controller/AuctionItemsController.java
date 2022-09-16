package com.garnerju.auctionhouse.controller;

import com.garnerju.auctionhouse.models.auctionmodels.AuctionItems;
import com.garnerju.auctionhouse.service.AuctionItemService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Log4j2
@RestController
public class AuctionItemsController {

    private AuctionItemService service;

    @GetMapping("/auctionlist")
    @ResponseStatus(HttpStatus.OK)
    public List<AuctionItems> getAuctionItems() {
        return service.getAuctionItems();
    }

}
