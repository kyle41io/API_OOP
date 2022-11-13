package utils;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProtocolException;

public interface IHttpRequest {

    public StringBuilder getRequest(String urlString, String token) throws MalformedURLException, ProtocolException, IOException;

    public StringBuilder postRequest(String urlString, String token) throws MalformedURLException, ProtocolException, IOException;

}
