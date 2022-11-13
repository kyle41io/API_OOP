package model;

public class BuyingUser {
    private String buying_user_id;
    private String selling_user_name;
    private String selling_user_phone;
    private String selling_user_address;

    public BuyingUser() {
    }

    public String getBuying_user_id() {
        return buying_user_id;
    }

    public void setBuying_user_id(String buying_user_id) {
        this.buying_user_id = buying_user_id;
    }

    public String getSelling_user_name() {
        return selling_user_name;
    }

    public void setSelling_user_name(String selling_user_name) {
        this.selling_user_name = selling_user_name;
    }

    public String getSelling_user_phone() {
        return selling_user_phone;
    }

    public void setSelling_user_phone(String selling_user_phone) {
        this.selling_user_phone = selling_user_phone;
    }

    public String getSelling_user_address() {
        return selling_user_address;
    }

    public void setSelling_user_address(String selling_user_address) {
        this.selling_user_address = selling_user_address;
    }
}
