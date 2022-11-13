package model;

public class Auction {
    private String auction_id;
    private String selling_user_id;
    private String title;
    private String start_date;
    private String end_date;
    private String statusId;
    private String status;
    private String updated_at;
    private String reason;
    private Category category;

    public Auction() {
    }

    public String getAuction_id() {
        return auction_id;
    }

    public String getSelling_user_id() {
        return selling_user_id;
    }

    public String getTitle() {
        return title;
    }

    public String getStart_date() {
        return start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public String getStatusId() {
        return statusId;
    }

    public String getStatus() {
        return status;
    }

    public Category getCategory() {
        return category;
    }

    public void setAuction_id(String auction_id) {
        this.auction_id = auction_id;
    }

    public void setSelling_user_id(String selling_user_id) {
        this.selling_user_id = selling_user_id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}