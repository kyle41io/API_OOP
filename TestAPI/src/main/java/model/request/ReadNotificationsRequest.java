package model.request;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import constant.URLConstant;
import model.Request;
import model.Response;
import model.response.GetNewsResponse;
import model.response.ReadNotificationsResponse;
import utils.HttpRequest;
import utils.IHttpRequest;
import utils.URL;

import java.io.IOException;

public class ReadNotificationsRequest extends Request {
    private String access_token;
    private String auction_id;

    public ReadNotificationsRequest() {
    }

    public String getAccess_token() {
        return access_token;
    }

    public String getAuction_id() {
        return auction_id;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public void setAuction_id(String auction_id) {
        this.auction_id = auction_id;
    }

    @Override
    public String getParamsString() {
        return null;
    }

    @Override
    public String getUrl_string() {
        return URL.getBaseURL() + URLConstant.READ_NOTIFICATIONS_URL + auction_id;
    }

    @Override
    public Response sendRequest() throws IOException {
        IHttpRequest httpRequest = new HttpRequest();
        StringBuilder content = httpRequest.getRequest(getUrl_string(), access_token);

        System.out.println(content);

        if (content == null || content.equals(""))
            return null;

        Gson g = new Gson();
        ReadNotificationsResponse rp;
        try {
            rp = g.fromJson(content.toString(), ReadNotificationsResponse.class);
        }catch (JsonSyntaxException e){
            e.printStackTrace();
            return null;
        }

        return rp;
    }
}