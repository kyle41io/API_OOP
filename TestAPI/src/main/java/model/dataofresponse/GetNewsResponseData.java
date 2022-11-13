package model.dataofresponse;


import model.New;

import java.util.Set;


public class GetNewsResponseData {
    private Set<New> news;
    private String total;

    public GetNewsResponseData() {
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}