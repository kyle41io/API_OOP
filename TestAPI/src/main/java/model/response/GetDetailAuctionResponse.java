package model.response;

import model.Response;
import model.dataofresponse.GetDetailAuctionResponseData;

public class GetDetailAuctionResponse extends Response {
    private GetDetailAuctionResponseData data;

    public GetDetailAuctionResponse() {
    }

    public GetDetailAuctionResponseData getData() {
        return data;
    }

    public void setData(GetDetailAuctionResponseData data) {
        this.data = data;
    }
}
