package model.request;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import constant.URLConstant;
import model.Request;
import model.Response;
import model.response.EditAccountResponse;
import utils.HttpRequest;
import utils.IHttpRequest;
import utils.URL;

import java.io.IOException;

public class EditAccountRequest extends Request {
    private String name;
    private String avatar;
    private String email;
    private String password;
    private String re_pass;
    private String address;
    private String phone;
    private String access_token;

    public EditAccountRequest() {
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

    public String getAccess_token() {
        return access_token;
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

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
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
        return URL.getBaseURL() + URLConstant.EDIT_ACCOUNT_URL + getParamsString();
    }

    @Override
    public Response sendRequest() throws IOException {
        IHttpRequest httpRequest = new HttpRequest();
        StringBuilder content = httpRequest.postRequest(getUrl_string(), access_token);

        if (content == null || content.equals(""))
            return null;

        Gson g = new Gson();
        EditAccountResponse rp;
        try {
            rp = g.fromJson(content.toString(), EditAccountResponse.class);
        }catch (JsonSyntaxException e){
            e.getStackTrace();
            return null;
        }

        return rp;
    }
}
