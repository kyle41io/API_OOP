package model.dataofresponse;

import model.Comment;

import model.request.CreateCommentRequest;

import java.util.Set;

public class CreateCommentResponeData {
    private Set<Comment> comments;
    private String total;



    public CreateCommentResponeData(){
    }





    public CreateCommentResponeData(Set<Comment> comments, String total) {
        this.comments = comments;
        this.total = total;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public String getTotal() {
        return total;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
