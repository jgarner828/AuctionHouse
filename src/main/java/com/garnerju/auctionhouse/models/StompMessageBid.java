package com.garnerju.auctionhouse.models;

import java.util.Objects;

public class StompMessageBid {

    private Long userId;
    private Long itemId;
    private Double bidAmount;

    public StompMessageBid(Long userId, Long itemId, Double bidAmount) {
        this.userId = userId;
        this.itemId = itemId;
        this.bidAmount = bidAmount;
    }
    public StompMessageBid() {   }


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Double getBidAmount() {
        return bidAmount;
    }

    public void setBidAmount(Double bidAmount) {
        this.bidAmount = bidAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StompMessageBid that = (StompMessageBid) o;
        return Objects.equals(userId, that.userId) && Objects.equals(itemId, that.itemId) && Objects.equals(bidAmount, that.bidAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, itemId, bidAmount);
    }

    @Override
    public String toString() {
        return "StompMessageModel{" +
                "userId=" + userId +
                ", itemId=" + itemId +
                ", bidAmount=" + bidAmount +
                '}';
    }
}
