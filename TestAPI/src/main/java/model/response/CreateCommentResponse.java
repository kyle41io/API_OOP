package model.response;

import model.Response;
import model.dataofresponse.CreateCommentResponeData;

public class CreateCommentResponse extends Response {
    private CreateCommentResponeData data;

    public CreateCommentResponse() {
        super();
    }

    public CreateCommentResponse(String code, String message, CreateCommentResponeData data) {
        super(code, message);
        this.data = data;
    }

    public CreateCommentResponeData getData() {
        return data;
    }

    public void setData(CreateCommentResponeData data) {
        this.data = data;
    }
}


