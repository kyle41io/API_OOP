package model.dataofresponse;

import model.Auction;

import java.util.Set;

public class GetListAuctionResponseData {

    private Set<Auction> auctions;
    private String total;

    public GetListAuctionResponseData() {
    }

    public Set<Auction> getAuctions() {
        return auctions;
    }

    public String getTotal() {
        return total;
    }

    public void setAuctions(Set<Auction> auctions) {
        this.auctions = auctions;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
