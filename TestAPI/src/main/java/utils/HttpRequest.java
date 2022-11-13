package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import static constant.MethodConstant.GET_METHOD;
import static constant.MethodConstant.POST_METHOD;
import static constant.URLConstant.TOKEN_TYPE;

public class HttpRequest implements IHttpRequest {
    public StringBuilder sendRequest(String urlString, String method, String token) throws MalformedURLException, ProtocolException,
            IOException {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        if (token != null) {
            System.out.println("***Token === " + token);
            connection.setRequestProperty("Authorization", TOKEN_TYPE + token);
        }

        connection.setRequestMethod(method);
        connection.setDoOutput(true);
        StringBuilder content = new StringBuilder("");

        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(connection.getInputStream()))) {
            if (connection.getResponseCode() != 200) {
                System.out.println("connection.getResponseCode() = " + connection.getResponseCode());
                return null;
            }


            String line;
            content = new StringBuilder();
            while ((line = in.readLine()) != null) {
                content.append(line);
                content.append(System.lineSeparator());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.disconnect();
        }

        return content;
    }

    @Override
    public StringBuilder getRequest(String urlString, String token) throws MalformedURLException, ProtocolException, IOException {
        return sendRequest(urlString, GET_METHOD, token);
    }

    @Override
    public StringBuilder postRequest(String urlString, String token) throws MalformedURLException, ProtocolException, IOException {
        return sendRequest(urlString, POST_METHOD, token);
    }

}
