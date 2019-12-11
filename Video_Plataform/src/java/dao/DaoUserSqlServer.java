package dao;

import dal.Conexion;
import dto.User;
import java.sql.ResultSet;
import java.util.ArrayList;

/*
 * @author Flavia Veizaga
 */
public class DaoUserSqlServer extends DaoUser {

    @Override
    public int insert(User obj) throws Exception {
        Conexion objConexion = Conexion.getOrCreate();

        int id = 0;
        StringBuilder query = new StringBuilder("INSERT INTO tbl_user VALUES (");
        query.append("'," + "'").append(obj.getUser_id());
        query.append("'").append(obj.getUser_name()).append("',");
        query.append("'").append(obj.getUser_email()).append("',");
        query.append("'").append(obj.getUser_phonenumber()).append("',");
        query.append("'").append(obj.getUser_password()).append("', ");
        query.append("'").append(obj.getUser_fullname()).append("' ");
        query.append(")");
        id = objConexion.ejecutarInsert(query.toString());
        if (id == 0) {
            throw new Exception("El registro no pudo ser insertado");
        }
        objConexion.desconectar();
        return id;
    }

    @Override
    public void update(User obj) throws Exception {
        Conexion objConexion = Conexion.getOrCreate();

        StringBuilder query = new StringBuilder("UPDATE tbl_user SET ");
        query.append("'").append(obj.getUser_name()).append("',");
        query.append("'").append(obj.getUser_email()).append("',");
        query.append("'").append(obj.getUser_phonenumber()).append("',");
        query.append("'").append(obj.getUser_password()).append("', ");
        query.append("'").append(obj.getUser_fullname()).append("' ");
        int upd = objConexion.ejecutarSimple(query.toString());
        if (upd == 0) {
            throw new Exception("El registro no pudo ser actualizado");
        }

        objConexion.desconectar();
    }

    @Override
    public void delete(int id) {
        Conexion objConexion = Conexion.getOrCreate();
        StringBuilder query = new StringBuilder("DELETE FROM tbl_user ");
        query.append("WHERE user_id = ").append(id);
        objConexion.ejecutarSimple(query.toString());
        objConexion.desconectar();
    }

    @Override
    public ArrayList<User> getList() {
        ArrayList<User> userList = new ArrayList<>();
        try {
            Conexion objConexion = Conexion.getOrCreate();
            String query = "SELECT * FROM tbl_user";
            ResultSet objResultSet = objConexion.ejecutar(query);
            if (objResultSet.next()) {
                User obj = new User();
                int user_id = objResultSet.getInt("user_id");
                obj.setUser_id(user_id);

                String user_name = objResultSet.getString("user_name");
                obj.setUser_name(user_name);

                String user_email = objResultSet.getString("user_email");
                obj.setUser_email(user_email);

                String user_phonenumber = objResultSet.getString("user_phonenumber");
                obj.setUser_phonenumber(user_phonenumber);

                String user_password = objResultSet.getString("user_password");
                obj.setUser_password(user_password);

                String user_fullname = objResultSet.getString("user_fullname");
                obj.setUser_fullname(user_fullname);

                userList.add(obj);
            }
        } catch (Exception ex) {
            ;
        }
        return userList;
    }

    @Override
    public User get(int id) {
        try {
            Conexion objConexion = Conexion.getOrCreate();
            String query = "SELECT * FROM tbl_user WHERE user_id = " + id;
            ResultSet objResultSet = objConexion.ejecutar(query);
            if (objResultSet.next()) {
                User obj = new User();
                int user_id = objResultSet.getInt("user_id");
                obj.setUser_id(user_id);

                String user_name = objResultSet.getString("user_name");
                obj.setUser_name(user_name);

                String user_email = objResultSet.getString("user_email");
                obj.setUser_email(user_email);

                String user_phonenumber = objResultSet.getString("user_phonenumber");
                obj.setUser_phonenumber(user_phonenumber);

                String user_password = objResultSet.getString("user_password");
                obj.setUser_password(user_password);

                String user_fullname = objResultSet.getString("user_fullname");
                obj.setUser_fullname(user_fullname);

                return obj;
            }
        } catch (Exception ex) {
            ;
        }
        return null;
    }

    @Override
    public ArrayList<User> getListFromIds(String ids) {
        ArrayList<User> registros = new ArrayList<>();
        if (ids == null || ids.trim().isEmpty()) {
            ids = "0";
        }
        try {
            Conexion objConexion = Conexion.getOrCreate();
            String query = "SELECT * FROM tbl_user WHERE user_id IN (" + ids + ")";
            ResultSet objResultSet = objConexion.ejecutar(query);
            while (objResultSet.next()) {
                User obj = new User();
                int user_id = objResultSet.getInt("user_id");
                obj.setUser_id(user_id);

                String user_name = objResultSet.getString("user_name");
                obj.setUser_name(user_name);

                String user_email = objResultSet.getString("user_email");
                obj.setUser_email(user_email);

                String user_phonenumber = objResultSet.getString("user_phonenumber");
                obj.setUser_phonenumber(user_phonenumber);

                String user_password = objResultSet.getString("user_password");
                obj.setUser_password(user_password);

                String user_fullname = objResultSet.getString("user_fullname");
                obj.setUser_fullname(user_fullname);

                registros.add(obj);
            }
        } catch (Exception ex) {
            ;
        }
        return registros;
    }

}
