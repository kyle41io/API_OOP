package model.response;

import model.Response;
import model.dataofresponse.LoginResponseData;
import model.dataofresponse.ReadNewsResponseData;

public class ReadNewsResponse extends Response {
    private ReadNewsResponseData data;

    public ReadNewsResponse() {
        super();
    }
    public ReadNewsResponseData getData() {
        return data;
    }
}