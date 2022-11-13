package model.request;

import model.Request;
import model.Response;

import java.io.IOException;

public class GetLAuctionByStatusIdRequest extends Request {
    private String access_token;
    private String statusId;
    private String index;
    private String count;

    public GetLAuctionByStatusIdRequest() {
    }

    public String getAccess_token() {
        return access_token;
    }

    public String getStatusId() {
        return statusId;
    }

    public String getIndex() {
        return index;
    }

    public String getCount() {
        return count;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public void setCount(String count) {
        this.count = count;
    }

    @Override
    public String getParamsString() {
        return null;
    }

    @Override
    public String getUrl_string() {
        return null;
    }

    @Override
    public Response sendRequest() throws IOException {
        return null;
    }
}
