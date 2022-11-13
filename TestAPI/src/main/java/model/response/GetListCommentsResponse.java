package model.response;

import model.Response;
import model.dataofresponse.GetListCommentResponseData;

public class GetListCommentsResponse extends Response {
    private GetListCommentResponseData data;

    public GetListCommentsResponse() {
        super();
    }

    public GetListCommentsResponse(String code, String message, GetListCommentResponseData data) {
        super(code, message);
        this.data = data;
    }

    public GetListCommentResponseData getData() {
        return data;
    }

    public void setData(GetListCommentResponseData data) {
        this.data = data;
    }
}

