package model;

public class Bid {

    private String user_name;

    private String user_avatar;

    private String price;

    private String updated_at;


    public Bid() {

    }

    public Bid(String user_name, String user_avatar, String price, String updated_at) {
        this.user_name = user_name;
        this.user_avatar = user_avatar;
        this.price = price;
        this.updated_at = updated_at;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getUser_avatar() {
        return user_avatar;
    }

    public String getPrice() {
        return price;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setUser_avatar(String user_avatar) {
        this.user_avatar = user_avatar;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public boolean equals(Bid bids) {
        if (bids == null)
            return false;

        if (user_name != null) {
            if (user_name.equals(bids.getUser_name()))
                return false;
        } else {
            if (bids.getUser_name() != null)
                return false;
        }


        if (user_avatar != null) {
            if (user_avatar.equals(bids.getUser_avatar()))
                return false;
        } else {
            if (bids.getUser_avatar() != null)
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
