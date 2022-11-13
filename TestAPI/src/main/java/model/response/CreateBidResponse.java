package model.response;

import model.Response;
import model.dataofresponse.CreateBidResponeData;


public class CreateBidResponse extends Response{
    private CreateBidResponeData data;

    public CreateBidResponse() {
        super();
    }

    public CreateBidResponse(String code, String message, CreateBidResponeData data) {
        super(code, message);
        this.data = data;
    }

    public CreateBidResponeData getData() {
        return data;
    }

    public void setData(CreateBidResponeData data) {
        this.data = data;
    }
}

