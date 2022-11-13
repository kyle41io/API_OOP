package model.response;

import model.Response;
import model.dataofresponse.EditAccountResponseData;
import model.dataofresponse.GetListAuctionResponseData;

public class GetListAuctionResponse extends Response {
    private GetListAuctionResponseData data;

    public GetListAuctionResponse() {
    }

    public GetListAuctionResponseData getData() {
        return data;
    }

    public void setData(GetListAuctionResponseData data) {
        this.data = data;
    }

}
