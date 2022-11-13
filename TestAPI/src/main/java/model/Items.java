package model;

import java.util.Set;

public class Items {
    private String name;
    private String brand;
    private String series;
    private String description;
    private String starting_price;
    private Set<String> mainImage;
    private Set<String> images;

    public Items() {
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