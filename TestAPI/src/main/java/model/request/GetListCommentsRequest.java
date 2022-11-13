package model.request;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import constant.URLConstant;
import model.Request;
import model.Response;
import model.response.GetListCommentsResponse;
import utils.HttpRequest;
import utils.IHttpRequest;
import utils.URL;

import java.io.IOException;

public class GetListCommentsRequest extends Request {
    private String index;
    private String count;
    private String access_token;
    private String auctionId;


    public GetListCommentsRequest() {

    }

    public GetListCommentsRequest(String index, String count, String auctionId) {
        this.index = index;
        this.count = count;
        this.auctionId = auctionId;
    }

    public String getIndex() {
        return index;
    }

    public String getCount() {
        return count;
    }

    public String getAuctionId() {
        return auctionId;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public void setAuctionId(String auctionId) {
        this.auctionId = auctionId;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
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
        return URL.getBaseURL() + URLConstant.GETLISTCOMMENTS_URL + "/" + auctionId + getParamsString();
    }

    @Override
    public Response sendRequest() throws IOException {
        IHttpRequest httpRequest = new HttpRequest();
        StringBuilder content = httpRequest.getRequest(getUrl_string(), access_token);

        if (content == null || content.equals(""))
            return null;

        System.out.println("Content = " + content);
        Gson g = new Gson();
        GetListCommentsResponse rp;
        try {
            rp = g.fromJson(content.toString(), GetListCommentsResponse.class);
        } catch (JsonSyntaxException e) {
            e.getStackTrace();
            return null;
        }

        return rp;
    }
}

