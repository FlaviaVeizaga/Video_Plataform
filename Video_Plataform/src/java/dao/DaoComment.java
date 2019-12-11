package dao;

import dto.Comment;
import java.util.ArrayList;

/*
 * @author Flavia Veizaga
 */
public abstract class DaoComment {

    public abstract int insert(Comment obj) throws Exception;

    public abstract void update(Comment obj) throws Exception;

    public abstract void delete(int id);

    public abstract ArrayList<Comment> getList();

    public abstract Comment get(int id);

    public abstract ArrayList<Comment> getListFromIds(String ids);

}
