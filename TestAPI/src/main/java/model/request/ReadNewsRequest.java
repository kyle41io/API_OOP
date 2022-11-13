package model.request;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import constant.URLConstant;
import model.Request;
import model.Response;
import model.response.GetNewsResponse;
import model.response.LoginResponse;
import model.response.ReadNewsResponse;
import utils.HttpRequest;
import utils.IHttpRequest;
import utils.URL;

import java.io.IOException;

public class ReadNewsRequest extends Request {
    private String access_token;
    private String news_id;

    public ReadNewsRequest() {
    }

    public String getAccess_token() {
        return access_token;
    }

    public String getNews_id() {
        return news_id;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public void setNews_id(String news_id) {
        this.news_id = news_id;
    }

    @Override
    public String getParamsString() {
        return null;
    }

    @Override
    public String getUrl_string() {
        return URL.getBaseURL() + URLConstant.READ_NEWS_URL + news_id;
    }

    @Override
    public Response sendRequest() throws IOException {
        IHttpRequest httpRequest = new HttpRequest();
        StringBuilder content = httpRequest.getRequest(getUrl_string(), access_token);

        System.out.println(content);

        if (content == null || content.equals(""))
            return null;

        Gson g = new Gson();
        ReadNewsResponse rp;
        try {
            rp = g.fromJson(content.toString(), ReadNewsResponse.class);
        }catch (JsonSyntaxException e){
            e.printStackTrace();
            return null;
        }

        return rp;
    }
}