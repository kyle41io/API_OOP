package model.response;

import model.Response;
import model.dataofresponse.ReadNotificationsResponseData;

public class ReadNotificationsResponse extends Response {
    private ReadNotificationsResponseData data;

    public ReadNotificationsResponse() {
        super();
    }
    public ReadNotificationsResponseData getData() {
        return data;
    }
}