package com.garnerju.auctionhouse.controller;

import com.garnerju.auctionhouse.models.auctionmodels.AuctionItems;
import com.garnerju.auctionhouse.service.AuctionItemService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;



@RestController
@Log4j2
public class AuctionItemsController {

    private AuctionItemService service;


    public AuctionItemsController(AuctionItemService service) {
        this.service = service;
    }


    @GetMapping("/auctionlist")
    @ResponseStatus(HttpStatus.OK)
    public List<AuctionItems> getAuctionItems() {
        log.info("getAuctionItems");
        return service.getAuctionItems();
    }

    @PostMapping("/auctionlist")
    @ResponseStatus(HttpStatus.CREATED)
    public void addAuctionItem(@RequestBody AuctionItems item) {
        log.info("addAuctionItem");
        service.addAuctionItem(item);
    };

}
