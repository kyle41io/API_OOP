package testpackage;

import constant.URLConstant;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;


import com.google.gson.Gson;
import model.response.SignUpResponse;

public class Test2 {
    public static void main(String[] args) throws MalformedURLException, ProtocolException,
            IOException {

        //Sign up
        System.out.println("Phien ban truyen tham so vao URL");
        URL url = new URL(utils.URL.getBaseURL() + URLConstant.LOGOUT_URL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);

        connection.setRequestProperty("Authorization", "Bearer " + "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOlwvXC9hdWN0aW9uLWFwcDMuaGVyb2t1YXBwLmNvbVwvYXBpXC9sb2dpbiIsImlhdCI6MTY1NjEyODkwNywiZXhwIjoxNjU2NDg4OTA3LCJuYmYiOjE2NTYxMjg5MDcsImp0aSI6IjI3d1FnNWV5R3d6NlZYU0EiLCJzdWIiOjk5LCJwcnYiOiIyM2JkNWM4OTQ5ZjYwMGFkYjM5ZTcwMWM0MDA4NzJkYjdhNTk3NmY3In0.pmbhHTtwbM3z_2tQdZboEke0vSaLJMnZDkWYzhWQOvY");

        try (DataOutputStream writer = new DataOutputStream(connection.getOutputStream())) {

            StringBuilder content;

            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()))) {

                String line;
                content = new StringBuilder();
                while ((line = in.readLine()) != null) {
                    content.append(line);
                    content.append(System.lineSeparator());
                }
            }
            System.out.println(content);

            System.out.println("JSON response: " + content.toString());

            Gson g = new Gson();
            SignUpResponse rp = g.fromJson(content.toString(), SignUpResponse.class);

            System.out.println("Unit test 1: The code and message strings shall be not NULL as well as non-empty:");
            assert(rp.getCode() != null && !"".equals(rp.getCode()));
            assert(rp.getMessage() != null && !"".equals(rp.getMessage()));
            System.out.println("Finished! Satisfied!");

        } finally {
            connection.disconnect();
        }
    }
}

