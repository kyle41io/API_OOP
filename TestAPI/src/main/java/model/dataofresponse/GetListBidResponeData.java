package model.dataofresponse;

import model.Bid;


import java.util.Set;

public class GetListBidResponeData {
    private Set<Bid> bids;

    private String total;



    public GetListBidResponeData(){

    }

    public GetListBidResponeData(Set<Bid> bids, String total) {
        this.bids = bids;
        this.total = total;
    }


    public Set<Bid> getBids() {
        return bids;
    }


    public String getTotal() {
        return total;
    }

    public void setBids(Set<Bid> bids) {
        this.bids = bids;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}

