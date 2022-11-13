package model.request;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import constant.URLConstant;
import model.Request;
import model.Response;
import model.response.CreateBidResponse;
import utils.HttpRequest;
import utils.IHttpRequest;
import utils.URL;

import java.io.IOException;

public class CreateBidRequest extends Request {
    private String access_token;
    private String auctionId;

    private String price;

    private String bid_last_id;






    public CreateBidRequest(){

    }


    public CreateBidRequest(String access_token, String price, String bid_last_id, String auctionId) {
        this.access_token = access_token;
        this.price = price;
        this.bid_last_id = bid_last_id;
        this.auctionId = auctionId;
    }

    public String getAccess_token() {
        return access_token;
    }

    public String getPrice() {
        return price;
    }

    public String getBid_last_id() {
        return bid_last_id;
    }

    public String getAuctionId() {
        return auctionId;
    }


    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setBid_last_id(String bid_last_id) {
        this.bid_last_id = bid_last_id;
    }
    public void setAuctionId(String auctionId) {
        this.auctionId = auctionId;
    }

    @Override
    public String getParamsString() {
        StringBuilder s = new StringBuilder("");

        if (price== null)
            s.append("?price=");
        else
            s.append("?price=" + price);

        if (bid_last_id == null)
            s.append("&bid_last_id=");
        else
            s.append("&bid_last_id=" + bid_last_id);

        return s.toString();
    }

    @Override
    public String getUrl_string() {
        return URL.getBaseURL() + URLConstant.CREATEBID_URL + "/" + auctionId + getParamsString();
    }

    @Override
    public Response sendRequest() throws IOException {
        IHttpRequest httpRequest = new HttpRequest();
        StringBuilder content = httpRequest.postRequest(getUrl_string(), access_token);

        if (content == null || content.equals(""))
            return null;

        System.out.println("Content = " + content);
        Gson g = new Gson();
        CreateBidResponse rp;
        try {
            rp = g.fromJson(content.toString(), CreateBidResponse.class);
        } catch (JsonSyntaxException e) {
            e.getStackTrace();
            return null;
        }

        return rp;
    }
}
