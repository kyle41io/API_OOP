package model.response;

import model.Response;

import model.dataofresponse.GetListBidResponeData;

public class GetListBidResponse extends Response {
    private GetListBidResponeData data;

    public GetListBidResponse() {
        super();
    }

    public GetListBidResponse(String code, String message, GetListBidResponeData data) {
        super(code, message);
        this.data = data;
    }

    public GetListBidResponeData getData() {
        return data;
    }

    public void setData(GetListBidResponeData data) {
        this.data = data;
    }
}
