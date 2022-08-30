package com.garnerju.auctionhouse.models.auctionmodels;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="auction_items")
public class AuctionItems {

    @Id
    @Column(name ="item_id")
    private Double id;
    @Column(name ="item_name")
    private String name;
    @Column(name ="item_description")
    private String desc;
    @Column(name ="item_image_url")
    private String image;


}
