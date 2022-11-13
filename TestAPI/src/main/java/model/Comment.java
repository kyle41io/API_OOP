package model;

public class Comment {
    private String auctiondId;
    private String user_id;
    private String content;
    private String updated_at;


    public Comment() {

    }

    public Comment(String auctiondId, String user_id, String content, String updated_at) {
        this.auctiondId = auctiondId;
        this.user_id = user_id;
        this.content = content;
        this.updated_at = updated_at;
    }

    public String getAuctiondId() {
        return auctiondId;
    }

    public String getUser_id() {
        return user_id;
    }

    public String getContent() {
        return content;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setAuctiondId(String auctiondId) {
        this.auctiondId = auctiondId;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public boolean equals(Comment comments) {
        if (comments == null)
            return false;

        if (user_id != null) {
            if (user_id.equals(comments.getUser_id()))
                return false;
        } else {
            if (comments.getUser_id() != null)
                return false;
        }


        if (content != null) {
            if (content.equals(comments.getContent()))
                return false;
        } else {
            if (comments.getContent() != null)
                return false;
        }

        if (updated_at != null) {
            if (updated_at.equals(comments.getUpdated_at()))
                return false;
        } else {
            if (comments.getUpdated_at() != null)
                return false;
        }

        return true;
    }
}
