package model.request;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import constant.URLConstant;
import model.Request;
import model.Response;
import model.response.LogoutResponse;
import utils.HttpRequest;
import utils.IHttpRequest;
import utils.URL;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogoutRequest extends Request {
    private String access_token;
    private String timeString;

    public LogoutRequest() {
    }

    public String getAccess_token() {
        return access_token;
    }

    public String getTimeString() {
        return timeString;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public void setTimeString(String timeString) {
        this.timeString = timeString;
    }

    @Override
    public String getParamsString() {
        StringBuilder s = new StringBuilder("");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/ddHH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        s.append("?time=" + dtf.format(now).toString());

        return s.toString();
    }

    @Override
    public String getUrl_string() {
        return URL.getBaseURL() + URLConstant.LOGOUT_URL + getParamsString();
    }

    @Override
    public Response sendRequest() throws IOException {
        IHttpRequest httpRequest = new HttpRequest();
        StringBuilder content = httpRequest.postRequest(getUrl_string(), access_token);

        System.out.println(content);

        if (content == null || content.equals(""))
            return null;

        Gson g = new Gson();
        LogoutResponse rp;
        try {
            rp = g.fromJson(content.toString(), LogoutResponse.class);
        }catch (JsonSyntaxException e){
            e.getStackTrace();
            return null;
        }

        return rp;
    }
}
