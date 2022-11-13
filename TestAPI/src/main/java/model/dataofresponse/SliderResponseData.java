package model.dataofresponse;

public class SliderResponseData {

    private String slider_id;
    private String image;
    private String type;
    private String created_at;
    private String updated_at;

    //CONSTRUCTOR
    public SliderResponseData() {
    }

    public String getSlider_id() {
        return slider_id;
    }

    public String getImage() {
        return image;
    }

    public String getType() {
        return type;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setSlider_id(String slider_id) {
        this.slider_id = slider_id;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
}