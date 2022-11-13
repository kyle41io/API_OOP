package model.response;

import model.Response;
import model.dataofresponse.ListAuctionsByUserResponseData;

public class ListAuctionsByUserResponse extends Response {
    private ListAuctionsByUserResponseData data;

    public ListAuctionsByUserResponse() {
    }

    public ListAuctionsByUserResponseData getData() {
        return data;
    }

    public void setData(ListAuctionsByUserResponseData data) {
        this.data = data;
    }
}
