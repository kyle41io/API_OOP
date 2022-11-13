package model.dataofresponse;

import model.Denys;

import java.util.Set;

public class GetNotificationsResponseData {
    private Set<Denys> denys;

    private String total_not_read;
    private String total;

    public GetNotificationsResponseData() {
    }

    public Set<Denys> getDenys() {
        return denys;
    }

    public void setDenys(Set<Denys> denys) {
        this.denys = denys;
    }

    public String getTotal_not_read() {
        return total_not_read;
    }

    public void setTotal_not_read(String total_not_read) {
        this.total_not_read = total_not_read;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}