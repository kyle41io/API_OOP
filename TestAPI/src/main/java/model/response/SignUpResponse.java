package model.response;

import model.Response;
import model.dataofresponse.SignUpResponseData;

public class SignUpResponse extends Response {
    private SignUpResponseData data;

    public SignUpResponse() {
        super();
    }

    public SignUpResponse(String code, String message, SignUpResponseData data) {
        super(code, message);
        this.data = data;
    }

    public SignUpResponseData getData() {
        return data;
    }

    public void setData(SignUpResponseData data) {
        this.data = data;
    }
}
