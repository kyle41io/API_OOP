package model.request;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import constant.URLConstant;
import model.Request;
import model.Response;
import model.response.GetListCategoriesResponse;
import utils.HttpRequest;
import utils.IHttpRequest;
import utils.URL;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class GetListCategoriesRequest extends Request {

    private String access_token;





    public GetListCategoriesRequest (){
    }

    public GetListCategoriesRequest(String access_token) {
        this.access_token = access_token;
    }

    public String getAccess_token() {
        return access_token;
    }



    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }





    @Override
    public String getParamsString() {
        return null;
    }

    @Override
    public String getUrl_string() {

        return URL.getBaseURL() + URLConstant.GETLISTCATEGORIES_URL;
    }

    @Override
    public Response sendRequest() throws IOException {
        IHttpRequest httpRequest = new HttpRequest();
        StringBuilder content = httpRequest.getRequest(getUrl_string(), access_token);

        System.out.println(content);

        if (content == null || content.equals(""))
            return null;

        System.out.println("Content = " + content);
        Gson g = new Gson();
        GetListCategoriesResponse rp;
        try {
            rp = g.fromJson(content.toString(), GetListCategoriesResponse.class);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
            return null;
        }

        return rp;
    }

}
