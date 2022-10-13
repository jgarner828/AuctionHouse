package com.garnerju.auctionhouse.models.auctionmodels;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="bids")
public class Bid {

    @Id
    @Column(name="bid_id")
    private String id;
    @Column(name="item_id")
    private Long itemId;
    @Column(name="user_email")
    private String email;
    @Column(name="bid_price")
    private Long bidPrice;
    @Column(name="bid_time")
    private Long bidTime;

    public Bid(Long item_id, String email, Long bidPrice, Long bidTime) {}
}
