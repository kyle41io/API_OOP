package model.response;

import model.Response;
import model.dataofresponse.LoginResponseData;

public class LoginResponse extends Response {
    private LoginResponseData data;

    public LoginResponse() {
        super();
    }

    public LoginResponse(String code, String message, LoginResponseData data) {
        super(code, message);
        this.data = data;
    }

    public LoginResponseData getData() {
        return data;
    }

    public void setData(LoginResponseData data) {
        this.data = data;
    }

//    @Override
//    public boolean equals(Response response) {
//        if (response ==  null)
//            return false;
//
//        LoginResponse rp = (LoginResponse) response;
//        if (getCode() != null) {
//            if (!getCode().equals(rp.getCode()))
//                return false;
//        }
//        else {
//            if (rp.getCode() != null)
//                return false;
//        }
//
//        if (getMessage() != null) {
//            if (!getMessage().equals(rp.getMessage()))
//                return false;
//        }
//        else {
//            if (rp.getMessage() != null)
//                return false;
//        }
//
//        if (data != null) {
//            if (!data.equals(rp.getData()))
//                return false;
//        }
//        else{
//            if (rp.getData() != null)
//                return false;
//        }
//
//        return true;
//    }
}
