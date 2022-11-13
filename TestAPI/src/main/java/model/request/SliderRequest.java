package model.request;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import constant.URLConstant;
import model.Request;
import model.Response;
import model.response.SliderResponse;
import utils.HttpRequest;
import utils.IHttpRequest;
import utils.URL;

import java.io.IOException;

public class SliderRequest extends Request {
    private String access_token;

    //CONSTRUCTOR
    public SliderRequest() {
    }

    //SETTER
    public String getAccess_token() {
        return access_token;
    }

    //GETTER
    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    @Override
    public String getParamsString() {
        return null;
    }

    @Override
    public String getUrl_string() {
        return URL.getBaseURL() + URLConstant.GET_SLIDER_URL;
    }

    @Override
    public Response sendRequest() throws IOException {
        IHttpRequest httpRequest = new HttpRequest();
        StringBuilder content = httpRequest.getRequest(getUrl_string(), null);

        if (content == null || content.equals(""))
            return null;

        Gson g = new Gson();
        SliderResponse rp;
        try {
            rp = g.fromJson(content.toString(), SliderResponse.class);
        }catch (JsonSyntaxException e){
            e.getStackTrace();
            return null;
        }

        return rp;
    }
}