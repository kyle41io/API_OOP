package model.request;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import constant.URLConstant;
import model.Request;
import model.Response;
import model.response.CreateItemResponse;
import utils.HttpRequest;
import utils.IHttpRequest;
import utils.URL;

import java.io.IOException;

public class CreateItemRequest extends Request {
    private String access_token;
    private String name;
    private String starting_price;
    private String brand_id;
    private String description;
    private String series;
    private String images;
    private String auctionId;





    public CreateItemRequest() {
    }

    public String getAccess_token() {
        return access_token;
    }

    public String getName() {
        return name;
    }

    public String getStarting_price() {
        return starting_price;
    }

    public String getBrand_id() {
        return brand_id;
    }

    public String getDescription() {
        return description;
    }

    public String getSeries() {
        return series;
    }

    public String getImages() {
        return images;
    }

    public String getAuctionId() {
        return auctionId;
    }
    public void setAuctionId(String auctionId) {
        this.auctionId = auctionId;
    }


    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStarting_price(String starting_price) {
        this.starting_price = starting_price;
    }

    public void setBrand_id(String brand_id) {
        this.brand_id = brand_id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public void setImages(String images) {
        this.images = images;
    }

    @Override
    public String getParamsString() {
        StringBuilder s = new StringBuilder("");

        if (name == null)
            s.append("?name=");
        else
            s.append("?name=" + name);

        if (starting_price == null)
            s.append("&starting_price=");
        else
            s.append("&starting_price=" + starting_price);

        if (brand_id == null)
            s.append("&brand_id=");
        else
            s.append("&brand_id=" + brand_id);

        if (description == null)
            s.append("&description=");
        else
            s.append("&description=" + description);

        if (series == null)
            s.append("&series=");
        else
            s.append("&series=" + series);

        if (images == null)
            s.append("&images=");
        else
            s.append("&images=" + images);
        return s.toString();
    }

    @Override
    public String getUrl_string() {
        return URL.getBaseURL() + URLConstant.CREATE_ITEM_URL + "/" +auctionId + getParamsString();
    }

    @Override
    public Response sendRequest() throws IOException {
        IHttpRequest httpRequest = new HttpRequest();
        StringBuilder content = httpRequest.postRequest(getUrl_string(), access_token);

        if (content == null || content.equals(""))
            return null;

        Gson g = new Gson();
        CreateItemResponse rp;
        try {
            rp = g.fromJson(content.toString(), CreateItemResponse.class);
        }catch (JsonSyntaxException e){
            e.getStackTrace();
            return null;
        }

        return rp;
    }
}
