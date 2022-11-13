package model;

public class New {
    private String user;
    private String new_id;
    private String title;
    private String content;
    private String updated_at;
    private String is_read;

    public New() {
    }

    public String getUser() {
        return user;
    }

    public String getNew_id() {
        return new_id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }


    public String getUpdate_at() {
        return updated_at;
    }

    public String getIs_read() {
        return is_read;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setNew_id(String new_id) {
        this.new_id = new_id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setUpdate_at(String update_at) {
        this.updated_at = update_at;
    }

    public void setIs_read(String is_read) {
        this.is_read = is_read;
    }
}