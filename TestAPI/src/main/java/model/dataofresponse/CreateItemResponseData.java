package model.dataofresponse;

import java.util.Set;

public class CreateItemResponseData {
    private String auction_id;
    private String brand_id;
    private String series;
    private String name;
    private String description;
    private Set<String> images;

    public CreateItemResponseData() {
    }


    public String getAuction_id() {
        return auction_id;
    }

    public String getBrand_id() {
        return brand_id;
    }

    public String getSeries() {
        return series;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Set<String> getImages() {
        return images;
    }

    public void setAuction_id(String auction_id) {
        this.auction_id = auction_id;
    }

    public void setBrand_id(String brand_id) {
        this.brand_id = brand_id;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImages(Set<String> images) {
        this.images = images;
    }
}
