package model.request;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import constant.URLConstant;
import model.Request;
import model.Response;
import model.response.GetNotificationsResponse;
import model.response.GetNotificationsResponse;
import model.response.LoginResponse;
import utils.HttpRequest;
import utils.IHttpRequest;
import utils.URL;

import java.io.IOException;

public class GetNotificationsRequest extends Request {
    private String access_token;
    private String index;
    private String count;
    private String is_not_read;

    public GetNotificationsRequest() {
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getIs_not_read() {
        return is_not_read;
    }

    public void setIs_not_read(String is_not_read) {
        this.is_not_read = is_not_read;
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

        if (is_not_read == null)
            s.append("&is_not_read=");
        else
            s.append("&is_not_read=" + count);

        return s.toString();
    }

    @Override
    public String getUrl_string() {
        return URL.getBaseURL() + URLConstant.GET_NOTIFICATIONS_URL + getParamsString();
    }

    @Override
    public Response sendRequest() throws IOException {
        IHttpRequest httpRequest = new HttpRequest();
        StringBuilder content = httpRequest.getRequest(getUrl_string(), null);

        if (content == null || content.equals(""))
            return null;

        Gson g = new Gson();
        GetNotificationsResponse rp;
        try {
            rp = g.fromJson(content.toString(), GetNotificationsResponse.class);
        }catch (JsonSyntaxException e){
            e.getStackTrace();
            return null;
        }

        return rp;
    }
}