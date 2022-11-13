package model.request;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import constant.URLConstant;
import model.Request;
import model.Response;
import model.response.CreateAuctionResponse;
import model.response.EditAuctionResponse;
import utils.HttpRequest;
import utils.IHttpRequest;
import utils.URL;

import java.io.IOException;

public class EditAuctionRequest extends Request {

    private String access_token;
    private String category_id;
    private String start_date;
    private String end_date;
    private String title_ni;

    private String auctionId;

    public EditAuctionRequest() {
    }

    public String getAuctionId() {
        return auctionId;
    }

    public String getAccess_token() {
        return access_token;
    }

    public String getCategory_id() {
        return category_id;
    }

    public String getStart_date() {
        return start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public String getTitle_ni() {
        return title_ni;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public void setTitle_ni(String title_ni) {
        this.title_ni = title_ni;
    }

    public void setAuctionId(String auctionId) {
        this.auctionId = auctionId;
    }

    @Override
    public String getParamsString() {
        StringBuilder s = new StringBuilder("");

        if (category_id == null)
            s.append("?category_id=");
        else
            s.append("?category_id=" + category_id);

        if (start_date == null)
            s.append("&start_date=");
        else
            s.append("&start_date=" + start_date);

        if (end_date == null)
            s.append("&end_date=");
        else
            s.append("&end_date=" + end_date);

        if (title_ni == null)
            s.append("&title_ni=");
        else
            s.append("&title_ni=" + title_ni);

        return s.toString();
    }

    @Override
    public String getUrl_string() {
        return URL.getBaseURL() + URLConstant.EDIT_AUCTION + "/" + auctionId + getParamsString();
    }

    @Override
    public Response sendRequest() throws IOException {
        IHttpRequest httpRequest = new HttpRequest();
        StringBuilder content = httpRequest.postRequest(getUrl_string(), access_token);

        if (content == null || content.equals(""))
            return null;

        Gson g = new Gson();
        EditAuctionResponse rp;
        try {
            rp = g.fromJson(content.toString(), EditAuctionResponse.class);
        }catch (JsonSyntaxException e){
            e.printStackTrace();
            return null;
        }

        return rp;
    }
}
