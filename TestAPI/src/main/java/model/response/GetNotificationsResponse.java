package model.response;

import model.Response;
import model.dataofresponse.GetNewsResponseData;
import model.dataofresponse.GetNotificationsResponseData;

public class GetNotificationsResponse extends Response {
    private GetNotificationsResponseData data;

    public GetNotificationsResponse() {
        super();
    }
    public GetNotificationsResponseData getData() {
        return data;
    }
}