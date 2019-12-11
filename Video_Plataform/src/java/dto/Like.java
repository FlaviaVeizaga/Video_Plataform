package dto;

/*
 * @author Flavia Veizaga
 */
public class Like {

    private int like_id;
    private int video_id;
    private int user_id;
    private boolean like_status;

    public Like() {
    }

    public Like(int video_id, int user_id, boolean like_status) {
        this.video_id = video_id;
        this.user_id = user_id;
        this.like_status = like_status;
    }

    public int getLike_id() {
        return like_id;
    }

    public void setLike_id(int like_id) {
        this.like_id = like_id;
    }

    public int getVideo_id() {
        return video_id;
    }

    public void setVideo_id(int video_id) {
        this.video_id = video_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public boolean isLike_status() {
        return like_status;
    }

    public void setLike_status(boolean like_status) {
        this.like_status = like_status;
    }

}
