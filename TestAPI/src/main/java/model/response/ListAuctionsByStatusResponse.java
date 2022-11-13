package model.response;

import model.Response;
import model.dataofresponse.ListAuctionsByStatusResponseData;

public class ListAuctionsByStatusResponse extends Response {
    private ListAuctionsByStatusResponseData data;

    public ListAuctionsByStatusResponse() {
    }

    public ListAuctionsByStatusResponseData getData() {
        return data;
    }

    public void setData(ListAuctionsByStatusResponseData data) {
        this.data = data;
    }
}
