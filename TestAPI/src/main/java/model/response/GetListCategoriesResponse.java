package model.response;

import model.Response;
import model.dataofresponse.GetListCategoriesResponseData;

import java.util.Set;


public class GetListCategoriesResponse extends Response {
    private Set<GetListCategoriesResponseData> data;

    public GetListCategoriesResponse() {
        super();
    }

    public Set<GetListCategoriesResponseData> getData() {
        return data;
    }

    public void setData(Set<GetListCategoriesResponseData> data) {
        this.data = data;
    }
}
