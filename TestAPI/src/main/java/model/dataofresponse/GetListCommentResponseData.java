 package model.dataofresponse;

 import model.Comments;

 import java.util.Set;

 public class GetListCommentResponseData {
     private Set<Comments> comments;

     private String total;

     public GetListCommentResponseData() {
     }

     public Set<Comments> getComments() {
         return comments;
     }

     public String getTotal() {
         return total;
     }

     public void setComments(Set<Comments> comments) {
         this.comments = comments;
     }

     public void setTotal(String total) {
         this.total = total;
     }
 }



