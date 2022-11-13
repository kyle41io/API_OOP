package model.request;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import constant.URLConstant;
import model.Request;
import model.Response;
import model.response.ListAuctionsByStatusResponse;
import utils.HttpRequest;
import utils.IHttpRequest;
import utils.URL;

import java.io.IOException;

public class ListAuctionsByStatusRequest extends Request {
    private String access_token;
    private String index;

    private String count;

    private String statusId;


    public ListAuctionsByStatusRequest() {
    }

    public String getStatusId() {
        return statusId;
    }

    public String getAccess_token() {
        return access_token;
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

    public void setIndex(String index) {
        this.index = index;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public void setAuctionsId(String statusId) {
        this.statusId = statusId;
    }

    @Override
    public String getParamsString() {
        StringBuilder s = new StringBuilder("");

        if (index == null)
            s.append("?index=");
        else
            s.append("?index=" + index);

        if (count == null)
            s.append("&count=");
        else
            s.append("&count=" + count);

        return s.toString();
    }



    @Override
    public String getUrl_string() {
        return URL.getBaseURL() + URLConstant.LIST_AUCTION_BY_STATUS + "/" + statusId + getParamsString();
    }

    @Override
    public Response sendRequest() throws IOException {
        IHttpRequest httpRequest = new HttpRequest();
        StringBuilder content = httpRequest.getRequest(getUrl_string(), access_token);

        if (content == null || content.equals(""))
            return null;

        Gson g = new Gson();
        ListAuctionsByStatusResponse rp;
        try {
            rp = g.fromJson(content.toString(), ListAuctionsByStatusResponse.class);
        }catch (JsonSyntaxException e){
            e.printStackTrace();
            return null;
        }

        return rp;
    }
}
