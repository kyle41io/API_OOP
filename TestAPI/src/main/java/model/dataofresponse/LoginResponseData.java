package model.dataofresponse;

import model.User;

public class LoginResponseData {
    private String access_token;
    private String token_type;
    private String expires_in;
    private User user;

    public LoginResponseData() {
    }

    public LoginResponseData(String access_token, String token_type, String expires_in, User user) {
        this.access_token = access_token;
        this.token_type = token_type;
        this.expires_in = expires_in;
        this.user = user;
    }

    public String getAccess_token() {
        return access_token;
    }

    public String getToken_type() {
        return token_type;
    }

    public String getExpires_in() {
        return expires_in;
    }

    public User getUser() {
        return user;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public void setExpires_in(String expires_in) {
        this.expires_in = expires_in;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean equals(LoginResponseData data){
        if (data == null)
            return false;

        if (user != null) {
            if (!user.equals(data.getUser()))
                return false;
        }
        else{
            if (data.getUser() != null)
                return false;
        }

        return true;
    }
}
