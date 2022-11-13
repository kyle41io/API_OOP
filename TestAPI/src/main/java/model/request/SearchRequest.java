package model.request;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import constant.URLConstant;
import model.Request;
import model.Response;
import model.response.GetNewsResponse;
import model.response.SearchResponse;
import utils.HttpRequest;
import utils.IHttpRequest;
import utils.URL;

import java.io.IOException;

public class SearchRequest extends Request {
    private String access_token;
    private String type;
    private String key;

    public SearchRequest() {
    }

    public String getAccess_token() {
        return access_token;
    }

    public String getType() {
        return type;
    }

    public String getKey() {
        return key;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setKey(String key) {
        this.key = key;
    }


    @Override
    public String getParamsString() {
        StringBuilder s = new StringBuilder("");

        if (type == null)
            s.append("?type=");
        else
            s.append("?type=" + type);

        if (key == null)
            s.append("&key=");
        else
            s.append("&key=" + key);

        return s.toString();
    }

    @Override
    public String getUrl_string() {
        return URL.getBaseURL() + URLConstant.SEARCH_URL + getParamsString();
    }

    @Override
    public Response sendRequest() throws IOException {
        IHttpRequest httpRequest = new HttpRequest();
        StringBuilder content = httpRequest.getRequest(getUrl_string(), null);

        System.out.println(content);

        if (content == null || content.equals(""))
            return null;

        Gson g = new Gson();
        SearchResponse rp;
        try {
            rp = g.fromJson(content.toString(), SearchResponse.class);
        }catch (JsonSyntaxException e){
            e.printStackTrace();
            return null;
        }

        return rp;
    }
}