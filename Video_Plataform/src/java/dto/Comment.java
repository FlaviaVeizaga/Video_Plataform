package dto;

/*
 * @author Flavia Veizaga
 */
public class Comment {

    private int comment_id;
    private String comment_body;
    private int user_id;
    private int video_id;
    private String comment_date;

    public Comment() {
    }

    public Comment(String comment_body, int user_id, int video_id, String comment_date) {
        this.comment_body = comment_body;
        this.user_id = user_id;
        this.video_id = video_id;
        this.comment_date = comment_date;
    }

    public int getComment_id() {
        return comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public String getComment_body() {
        return comment_body;
    }

    public void setComment_body(String comment_body) {
        this.comment_body = comment_body;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getVideo_id() {
        return video_id;
    }

    public void setVideo_id(int video_id) {
        this.video_id = video_id;
    }
    
    public String getComment_date(){
        return comment_date;
    }
    
    public void setComment_date(String comment_date){
        this.comment_date = comment_date;
    }

}
