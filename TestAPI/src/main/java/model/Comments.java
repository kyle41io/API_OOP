package model;

public class Comments {
    private String comment_id;
    private String user_name;
    private String user_avatar;
    private String content;
    private String updated_at;

    public Comments (){

    }

    public Comments(String user_name, String user_avatar, String content, String updated_at) {
        this.user_name = user_name;
        this.user_avatar = user_avatar;
        this.content = content;
        this.updated_at = updated_at;
    }

    public String getComment_id() {
        return comment_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getUser_avatar() {
        return user_avatar;
    }

    public String getContent() {
        return content;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setComment_id(String comment_id) {
        this.comment_id = comment_id;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setUser_avatar(String user_avatar) {
        this.user_avatar = user_avatar;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public boolean equals(Comments comments) {
        if (comments == null)
            return false;

        if (user_name != null){
            if (user_name.equals(comments.getUser_name()))
                return false;
        }
        else {
            if (comments.getUser_name() != null)
                return false;
        }

        if (user_avatar != null){
            if (user_avatar.equals(comments.getUser_avatar()))
                return false;
        }
        else {
            if (comments.getUser_avatar() != null)
                return false;
        }

        if (content != null){
            if (content.equals(comments.getContent()))
                return false;
        }
        else {
            if (comments.getContent() != null)
                return false;
        }

        if (updated_at != null){
            if (updated_at.equals(comments.getUpdated_at()))
                return false;
        }
        else {
            if (comments.getUpdated_at() != null)
                return false;
        }

        return true;
    }
}