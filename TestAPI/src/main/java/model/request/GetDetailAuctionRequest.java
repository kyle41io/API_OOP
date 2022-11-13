package model.request;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import constant.URLConstant;
import model.Request;
import model.Response;
import model.response.GetDetailAuctionResponse;
import utils.HttpRequest;
import utils.IHttpRequest;
import utils.URL;

import java.io.IOException;

public class GetDetailAuctionRequest extends Request {
    private String access_token;

    private String auctionId;


    public GetDetailAuctionRequest() {
    }

    public String getAuctionId() {
        return auctionId;
    }

    public String getAccess_token() {
        return access_token;
    }


    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }


    public void setAuctionsId(String statusId) {
        this.auctionId = statusId;
    }

    @Override
    public String getParamsString() {
        StringBuilder s = new StringBuilder("");

        return s.toString();
    }



    @Override
    public String getUrl_string() {
        return URL.getBaseURL() + URLConstant.GET_DETAIL_AUCTION + "/" + auctionId + getParamsString();
    }

    @Override
    public Response sendRequest() throws IOException {
        IHttpRequest httpRequest = new HttpRequest();
        StringBuilder content = httpRequest.getRequest(getUrl_string(), access_token);

        if (content == null || content.equals(""))
            return null;

        Gson g = new Gson();
        GetDetailAuctionResponse rp;
        try {
            rp = g.fromJson(content.toString(), GetDetailAuctionResponse.class);
        }catch (JsonSyntaxException e){
            e.printStackTrace();
            return null;
        }

        return rp;
    }
}
