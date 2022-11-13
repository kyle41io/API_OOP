package model.response;

import model.Response;
import model.dataofresponse.CreateAuctionResponseData;

public class CreateAuctionResponse extends Response {
    private CreateAuctionResponseData data;

    public CreateAuctionResponse() {
    }

    public CreateAuctionResponseData getData() {
        return data;
    }

    public void setData(CreateAuctionResponseData data) {
        this.data = data;
    }
}
