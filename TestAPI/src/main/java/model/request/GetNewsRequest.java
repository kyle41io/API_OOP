package model.request;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import constant.URLConstant;
import model.Request;
import model.Response;
import model.response.GetNewsResponse;
import model.response.LogoutResponse;
import utils.HttpRequest;
import utils.IHttpRequest;
import utils.URL;

import java.io.IOException;

public class GetNewsRequest extends Request {
    private String access_token;
    private String index;
    private String count;

    public GetNewsRequest() {
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
        return URL.getBaseURL() + URLConstant.GET_NEWS_URL + getParamsString();
    }

    @Override
    public Response sendRequest() throws IOException {
        IHttpRequest httpRequest = new HttpRequest();
        StringBuilder content = httpRequest.getRequest(getUrl_string(), access_token);

        System.out.println(content);

        if (content == null || content.equals(""))
            return null;

        Gson g = new Gson();
        GetNewsResponse rp;
        try {
            rp = g.fromJson(content.toString(), GetNewsResponse.class);
        }catch (JsonSyntaxException e){
            e.printStackTrace();
            return null;
        }

        return rp;
    }
}