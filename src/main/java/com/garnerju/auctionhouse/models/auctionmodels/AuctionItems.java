package com.garnerju.auctionhouse.models.auctionmodels;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="auction_items")
public class AuctionItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="item_id")
    private Long id;
    @Column(name ="item_name")
    private String name;
    @Column(name ="item_description")
    private String desc;
    @Column(name ="item_image_url")
    private String image;
    @Column(name ="item_starting_price")
    private Long itemStartingPrice;
    @Column(name ="item_min_bid")
    private Long itemMinBid;

    public AuctionItems(String name, String desc, String image, Long itemStartingPrice, Long itemMinBid) {
        this.name = name;
        this.desc = desc;
        this.image = image;
        this.itemStartingPrice = itemStartingPrice;
        this.itemMinBid = itemMinBid;
    }


}
