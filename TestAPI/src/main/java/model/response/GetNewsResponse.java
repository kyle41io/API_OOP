package model.response;

import model.Response;
import model.dataofresponse.GetNewsResponseData;
import model.dataofresponse.LoginResponseData;

public class GetNewsResponse extends Response {
    private GetNewsResponseData data;

    public GetNewsResponse() {
        super();
    }
    public GetNewsResponseData getData() {
        return data;
    }
}