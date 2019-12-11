package dao;

import dto.User;
import java.util.ArrayList;

/*
 * @author Flavia Veizaga
 */
public abstract class DaoUser {

    public abstract int insert(User obj) throws Exception;

    public abstract void update(User obj) throws Exception;

    public abstract void delete(int id);

    public abstract ArrayList<User> getList();

    public abstract User get(int id);

    public abstract ArrayList<User> getListFromIds(String ids);
}
