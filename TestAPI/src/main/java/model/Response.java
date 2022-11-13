package model;


public abstract class Response {
    private String code;
    private String message;

    public Response() {
    }

    public Response(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean equals(Response response) {
        if (response ==  null)
            return false;

        if (getCode() != null) {
            if (!getCode().equals(response.getCode()))
                return false;
        }
        else {
            if (response.getCode() != null)
                return false;
        }

        if (getMessage() != null) {
            if (!getMessage().equals(response.getMessage()))
                return false;
        }
        else {
            if (response.getMessage() != null)
                return false;
        }

        return true;
    }
}
