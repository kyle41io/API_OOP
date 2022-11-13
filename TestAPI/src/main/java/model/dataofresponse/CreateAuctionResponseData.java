package model.dataofresponse;

public class CreateAuctionResponseData {
    private String auction_id;
    private String selling_user_id;
    private String title;
    private String category_id;
    private String start_date;
    private String end_date;
    private String status;
    private String reason;

    public CreateAuctionResponseData() {
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

    public String getCategory_id() {
        return category_id;
    }

    public String getStart_date() {
        return start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public String getStatus() {
        return status;
    }

    public String getReason() {
        return reason;
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

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
