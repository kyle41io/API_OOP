package model.dataofresponse;

import model.Bids;

import model.request.CreateBidRequest;

import java.util.Set;

public class CreateBidResponeData {

    private Set<Bids> bids;

    private String total;



    public CreateBidResponeData(){

    }



    public CreateBidResponeData(Set<Bids> bids, String total) {
        this.bids = bids;
        this.total = total;
    }

    public Set<Bids> getBids() {
        return bids;
    }


    public String getTotal() {
        return total;
    }

    public void setBids(Set<Bids> bids) {
        this.bids = bids;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
