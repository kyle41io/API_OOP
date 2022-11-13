package model.response;

import model.Response;
import model.dataofresponse.ListAuctionsByUserResponseData;

public class ListAuctionsByTypeResponse extends Response {
    private ListAuctionsByUserResponseData data;

    public ListAuctionsByTypeResponse() {
    }

    public ListAuctionsByUserResponseData getData() {
        return data;
    }

    public void setData(ListAuctionsByUserResponseData data) {
        this.data = data;
    }
}
