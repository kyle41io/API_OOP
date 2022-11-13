package model.response;

import model.Response;
import model.dataofresponse.SliderResponseData;

import java.util.Set;

public class SliderResponse extends Response {
    private Set<SliderResponseData> data;

    public SliderResponse() {
        super();
    }

    public Set<SliderResponseData> getData() {
        return data;
    }

    public void setData(Set<SliderResponseData> data) {
        this.data = data;
    }
}