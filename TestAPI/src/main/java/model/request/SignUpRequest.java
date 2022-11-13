package model.request;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import constant.URLConstant;
import model.Request;
import model.Response;
import model.response.SignUpResponse;
import utils.HttpRequest;
import utils.IHttpRequest;
import utils.URL;

import java.io.IOException;

public class SignUpRequest extends Request {
    private String name;
    private String avatar;
    private String email;
    private String password;
    private String re_pass;
    private String address;
    private String phone;

    public SignUpRequest() {
    }

    public SignUpRequest(String name, String avatar, String email, String password, String re_pass, String address, String phone) {
        this.name = name;
        this.avatar = avatar;
        this.email = email;
        this.password = password;
        this.re_pass = re_pass;
        this.address = address;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRe_pass() {
        return re_pass;
    }

    public void setRe_pass(String re_pass) {
        this.re_pass = re_pass;
    }

    @Override
    public String getParamsString() {
        StringBuilder s = new StringBuilder("");

        if (email == null)
            s.append("?email=");
        else
            s.append("?email=" + email);

        if (password == null)
            s.append("&password=");
        else
            s.append("&password=" + password);

        if (re_pass == null)
            s.append("&re_pass=");
        else
            s.append("&re_pass=" + re_pass);

        if (address == null)
            s.append("&address=");
        else
            s.append("&address=" + address);

        if (name == null)
            s.append("&name=");
        else
            s.append("&name=" + name);

        if (phone == null)
            s.append("&phone=");
        else
            s.append("&phone=" + phone);

        if (avatar == null)
            s.append("&avatar=");
        else
            s.append("&avatar=" + avatar);

        return s.toString();
    }

    @Override
    public String getUrl_string() {
        return URL.getBaseURL() + URLConstant.SIGN_UP_URL + getParamsString();
    }

    @Override
    public Response sendRequest() throws IOException {
        IHttpRequest httpRequest = new HttpRequest();
        StringBuilder content = httpRequest.postRequest(getUrl_string(), null);

        if (content == null || content.equals(""))
            return null;

        Gson g = new Gson();
        SignUpResponse rp;
        try {
            rp = g.fromJson(content.toString(), SignUpResponse.class);
        }catch (JsonSyntaxException e){
            e.getStackTrace();
            return null;
        }

        return rp;
    }
}
