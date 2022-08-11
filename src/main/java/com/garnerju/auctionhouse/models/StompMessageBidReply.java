package com.garnerju.auctionhouse.models;

import java.util.Objects;

public class StompMessageBidReply {

    private String content;

    public StompMessageBidReply(String content) {
        this.content = content;
    }

    public StompMessageBidReply(){}

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StompMessageBidReply that = (StompMessageBidReply) o;
        return Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content);
    }

    @Override
    public String toString() {
        return "StompMessageBidReply{" +
                "content='" + content + '\'' +
                '}';
    }
}
