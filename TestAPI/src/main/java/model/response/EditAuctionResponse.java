package model.response;

import model.Response;
import model.dataofresponse.CreateAuctionResponseData;
import model.dataofresponse.EditAuctionResponseData;

public class EditAuctionResponse  extends Response {
    private EditAuctionResponseData data;

    public EditAuctionResponse() {
    }

    public EditAuctionResponseData getData() {
        return data;
    }

    public void setData(EditAuctionResponseData data) {
        this.data = data;
    }
}
