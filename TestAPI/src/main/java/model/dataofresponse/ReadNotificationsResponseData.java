package model.dataofresponse;

import model.*;

import java.util.Set;

public class ReadNotificationsResponseData {
    private String is_read;
    private String auction_id;
    private String type;
    private Auction auctions;
    private Category category;
    private Items items;
    private String total_not_read;
    private String total;

    public Auction getAuctions() {
        return auctions;
    }

    public Category getCategory() {
        return category;
    }

    public Items getItems() {
        return items;
    }

    public void setAuctions(Auction auctions) {
        this.auctions = auctions;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setItems(Items items) {
        this.items = items;
    }

    public ReadNotificationsResponseData() {
    }

    public String getIs_read() {
        return is_read;
    }

    public String getAuction_id() {
        return auction_id;
    }

    public String getType() {
        return type;
    }

    public String getTotal_not_read() {
        return total_not_read;
    }

    public String getTotal() {
        return total;
    }

    public void setIs_read(String is_read) {
        this.is_read = is_read;
    }

    public void setAuction_id(String auction_id) {
        this.auction_id = auction_id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setTotal_not_read(String total_not_read) {
        this.total_not_read = total_not_read;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}