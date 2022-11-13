package model;

import java.io.IOException;

public abstract class Request {
    public abstract String getParamsString();

    public abstract String getUrl_string();

    public abstract Response sendRequest() throws IOException;
}
