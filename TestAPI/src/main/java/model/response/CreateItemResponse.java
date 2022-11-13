package model.response;

import model.Response;
import model.dataofresponse.CreateItemResponseData;

public class CreateItemResponse extends Response {
    private CreateItemResponseData data;

    public CreateItemResponse() {
        super();
    }

    public CreateItemResponse(String code, String message, CreateItemResponseData data) {
        super(code, message);
        this.data = data;
    }

    public CreateItemResponseData getData() {
        return data;
    }

    public void setData(CreateItemResponseData data) {
        this.data = data;
    }
}