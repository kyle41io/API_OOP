package model.response;

import model.Response;
import model.dataofresponse.EditAccountResponseData;

public class EditAccountResponse extends Response {
    private EditAccountResponseData data;

    public EditAccountResponse() {
    }

    public EditAccountResponseData getData() {
        return data;
    }

    public void setData(EditAccountResponseData data) {
        this.data = data;
    }
}
