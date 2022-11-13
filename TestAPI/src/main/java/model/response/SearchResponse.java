package model.response;

import model.Response;

import model.dataofresponse.SearchResponseData;

import java.util.Set;

public class SearchResponse extends Response {
    private Set<SearchResponseData> data;

    public SearchResponse() {
        super();
    }

    public Set<SearchResponseData> getData() {
        return data;
    }

    public void setData(Set<SearchResponseData> data) {
        this.data = data;
    }
}