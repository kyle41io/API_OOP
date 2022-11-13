package model.dataofresponse;

import model.*;


public class GetDetailAuctionResponseData {
    private Auction auctions;
    private Category category;
    private Item items;
    private SellingUser selling_user;
    private BuyingUser buying_user;
    private String max_bid;
    private String like;

    public GetDetailAuctionResponseData() {
    }

    public Auction getAuctions() {
        return auctions;
    }

    public void setAuctions(Auction auctions) {
        this.auctions = auctions;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Item getItems() {
        return items;
    }

    public void setItems(Item items) {
        this.items = items;
    }

    public SellingUser getSelling_user() {
        return selling_user;
    }

    public void setSelling_user(SellingUser selling_user) {
        this.selling_user = selling_user;
    }

    public BuyingUser getBuying_user() {
        return buying_user;
    }

    public void setBuying_user(BuyingUser buying_user) {
        this.buying_user = buying_user;
    }

    public String getMax_bid() {
        return max_bid;
    }

    public void setMax_bid(String max_bid) {
        this.max_bid = max_bid;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }
}





