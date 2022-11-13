package model;

import java.util.Set;

public class Item {
    private String item_id;
    private String name;
    private String buying_user_id;
    private String brand;
    private String series;
    private String description;
    private String starting_price;
    private String selling_info;
    private String mainImage;
    private Set<String> images;

    public Item() {
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public String getSeries() {
        return series;
    }

    public String getDescription() {
        return description;
    }

    public String getStarting_price() {
        return starting_price;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStarting_price(String starting_price) {
        this.starting_price = starting_price;
    }


}