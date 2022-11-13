package model;

public class Bids {
    private String user_id;
    private String auction_id;
    private String price;
    private String updated_at;

    public Bids() {
    }

    public Bids(String user_id, String auction_id, String price, String updated_at) {
        this.user_id = user_id;
        this.auction_id = auction_id;
        this.price = price;
        this.updated_at = updated_at;
    }

    public String getUser_id() {
        return user_id;
    }

    public String getAuction_id() {
        return auction_id;
    }

    public String getPrice() {
        return price;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public void setAuction_id(String auction_id) {
        this.auction_id = auction_id;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public boolean equals(Bids bids) {
        if (bids == null)
            return false;

        if (user_id != null) {
            if (user_id.equals(bids.getUser_id()))
                return false;
        } else {
            if (bids.getUser_id() != null)
                return false;
        }


        if (auction_id != null) {
            if (auction_id.equals(bids.getAuction_id()))
                return false;
        } else {
            if (bids.getAuction_id() != null)
                return false;
        }

        if (price != null) {
            if (price.equals(bids.getPrice()))
                return false;
        } else {
            if (bids.getPrice() != null)
                return false;
        }

        if (updated_at != null) {
            if (updated_at.equals(bids.getUpdated_at()))
                return false;
        } else {
            if (bids.getUpdated_at() != null)
                return false;
        }
        return true;
    }
}

