package com.garnerju.auctionhouse.models.auctionmodels;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="bids")
public class Bid {

    @Id
    @Column(name="bid_id")
    private Double id;
    @Column(name="item_id")
    private Double itemId;
    @Column(name="user_email")
    private String email;
    @Column(name="bid_price")
    private Double bidPrice;
    @Column(name="bid_time")
    private Double bidTime;
}
