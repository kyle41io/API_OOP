package model.response;

import model.Response;
import model.dataofresponse.GetLAuctionByStatusIdResponseData;

public class GetLAuctionByStatusIdResponse extends Response {
    private GetLAuctionByStatusIdResponseData data;

    public GetLAuctionByStatusIdResponse() {
    }

    public GetLAuctionByStatusIdResponseData getData() {
        return data;
    }

    public void setData(GetLAuctionByStatusIdResponseData data) {
        this.data = data;
    }

}
