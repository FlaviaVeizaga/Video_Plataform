package dao;

import dto.Like;
import java.util.ArrayList;

/*
 * @author Flavia Veizaga
 */
public abstract class DaoLike {

    public abstract int insert(Like obj) throws Exception;

    public abstract void update(Like obj) throws Exception;

    public abstract void delete(int id);

    public abstract ArrayList<Like> getList();

    public abstract Like get(int id);

    public abstract ArrayList<Like> getListFromIds(String ids);
}
