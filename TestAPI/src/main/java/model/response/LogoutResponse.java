package model.response;

import model.Response;

public class LogoutResponse extends Response {
    private String data;

    public LogoutResponse() {
        super();
    }

    public LogoutResponse(String code, String message, String data) {
        super(code, message);
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
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
