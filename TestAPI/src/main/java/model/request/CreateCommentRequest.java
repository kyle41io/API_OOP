package model.request;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import constant.URLConstant;
import model.Request;
import model.Response;
import model.response.CreateCommentResponse;
import utils.HttpRequest;
import utils.IHttpRequest;
import utils.URL;

import java.io.IOException;

public class CreateCommentRequest extends Request {
    private String access_token;
    private String content;
    private String comment_last_id;

    private String auctionId;







    public CreateCommentRequest(){

    }
    public CreateCommentRequest(String access_token, String content, String comment_last_id, String auctionId) {
        this.access_token = access_token;
        this.content = content;
        this.comment_last_id = comment_last_id;
        this.auctionId = auctionId;
    }

    public String getAccess_token() {
        return access_token;
    }

    public String getContent() {
        return content;
    }

    public String getComment_last_id() {
        return comment_last_id;
    }

    public String getAuctionId() {
        return auctionId;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setComment_last_id(String comment_last_id) {
        this.comment_last_id = comment_last_id;
    }

    public void setAuctionId(String auctionId) {
        this.auctionId = auctionId;
    }



    @Override
    public String getParamsString() {
        StringBuilder s = new StringBuilder("");

        if (content== null)
            s.append("?content=");
        else
            s.append("?content=" + content);

        if (comment_last_id == null)
            s.append("&comment_last_id=");
        else
            s.append("&comment_last_id=" + comment_last_id);

        return s.toString();
    }

    @Override
    public String getUrl_string() {
        return URL.getBaseURL() + URLConstant.CREATECOMMENT_URL + "/" + auctionId + getParamsString();
    }

    @Override
    public Response sendRequest() throws IOException {
        IHttpRequest httpRequest = new HttpRequest();
        StringBuilder content = httpRequest.postRequest(getUrl_string(), access_token);

        if (content == null || content.equals(""))
            return null;

        System.out.println("Content = " + content);
        Gson g = new Gson();
        CreateCommentResponse rp;
        try {
            rp = g.fromJson(content.toString(), CreateCommentResponse.class);
        } catch (JsonSyntaxException e) {
            e.getStackTrace();
            return null;
        }

        return rp;
    }
}