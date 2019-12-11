package dto;

/*
 * @author Flavia Veizaga
 */
public class Video {

    private int video_id;
    private String video_name;
    private String video_url;
    private int user_id;

    public Video() {
    }

    public Video(String video_name, String video_url, int user_id) {
        this.video_name = video_name;
        this.video_url = video_url;
        this.user_id = user_id;
    }

    public int getVideo_id() {
        return video_id;
    }

    public void setVideo_id(int video_id) {
        this.video_id = video_id;
    }

    public String getVideo_name() {
        return video_name;
    }

    public void setVideo_name(String video_name) {
        this.video_name = video_name;
    }

    public String getVideo_url() {
        return video_url;
    }

    public void setVideo_url(String video_url) {
        this.video_url = video_url;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

}
