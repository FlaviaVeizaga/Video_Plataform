package dao;

import dto.Video;
import java.util.ArrayList;

/*
 * @author Flavia Veizaga
 */
public abstract class DaoVideo {

    public abstract int insert(Video obj) throws Exception;

    public abstract void update(Video obj) throws Exception;

    public abstract void delete(int id);

    public abstract ArrayList<Video> getList();

    public abstract Video get(int id);

    public abstract ArrayList<Video> getListFromIds(String ids);

}
