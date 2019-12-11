package dao;

import dal.Conexion;
import dto.Like;
import java.sql.ResultSet;
import java.util.ArrayList;

/*
 * @author Flavia Veizaga
 */
public class DaoLikeSqlserver extends DaoLike {

    @Override
    public int insert(Like obj) throws Exception {
        Conexion objConexion = Conexion.getOrCreate();

        int id = 0;
        StringBuilder query = new StringBuilder("INSERT INTO tbl_like VALUES (");
        query.append("'").append(obj.getLike_id()).append("',");
        query.append("'").append(obj.getVideo_id()).append("',");
        query.append("'").append(obj.getUser_id()).append("',");
        query.append("'").append(obj.isLike_status()).append("' ");
        query.append(")");

        id = objConexion.ejecutarInsert(query.toString());
        if (id == 0) {
            throw new Exception("El registro no pudo ser insertado");
        }
        objConexion.desconectar();
        return id;
    }

    @Override
    public void update(Like obj) throws Exception {
        Conexion objConexion = Conexion.getOrCreate();

        StringBuilder query = new StringBuilder("UPDATE tbl_like SET ");
        query.append("'").append(obj.getVideo_id()).append("',");
        query.append("'").append(obj.getUser_id()).append("',");
        query.append("'").append(obj.isLike_status()).append("' ");
        query.append("WHERE like_id = ").append(obj.getLike_id());
        int upd = objConexion.ejecutarSimple(query.toString());
        if (upd == 0) {
            throw new Exception("El registro no pudo ser actualizado");
        }

        objConexion.desconectar();
    }

    @Override
    public void delete(int id) {
        Conexion objConexion = Conexion.getOrCreate();
        StringBuilder query = new StringBuilder("DELETE FROM tbl_like ");
        query.append("WHERE like_id = ").append(id);
        objConexion.ejecutarSimple(query.toString());
        objConexion.desconectar();
    }

    @Override
    public ArrayList<Like> getList() {
        ArrayList<Like> likeList = new ArrayList<>();
        try {
            Conexion objConexion = Conexion.getOrCreate();
            String query = "SELECT * FROM tbl_like";
            ResultSet objResultSet = objConexion.ejecutar(query);
            while (objResultSet.next()) {
                Like obj = new Like();
                int like_id = objResultSet.getInt("like_id");
                obj.setLike_id(like_id);

                int video_id = objResultSet.getInt("video_id");
                obj.setVideo_id(video_id);

                int user_id = objResultSet.getInt("user_id");
                obj.setUser_id(user_id);

                boolean like_status = objResultSet.getBoolean("like_status");
                obj.setLike_status(like_status);

                likeList.add(obj);
            }
        } catch (Exception ex) {
            ;
        }
        return likeList;
    }

    @Override
    public Like get(int id) {
        try {
            Conexion objConexion = Conexion.getOrCreate();
            String query = "SELECT * FROM tbl_like WHERE comment_id = " + id;
            ResultSet objResultSet = objConexion.ejecutar(query);
            if (objResultSet.next()) {
                Like obj = new Like();
                int like_id = objResultSet.getInt("like_id");
                obj.setLike_id(like_id);

                int video_id = objResultSet.getInt("video_id");
                obj.setVideo_id(video_id);

                int user_id = objResultSet.getInt("user_id");
                obj.setUser_id(user_id);

                boolean like_status = objResultSet.getBoolean("like_status");
                obj.setLike_status(like_status);

                return obj;
            }
        } catch (Exception ex) {
            ;
        }
        return null;
    }

    @Override
    public ArrayList<Like> getListFromIds(String ids) {
        ArrayList<Like> commentList = new ArrayList<>();
        if (ids == null || ids.trim().isEmpty()) {
            ids = "0";
        }
        try {
            Conexion objConexion = Conexion.getOrCreate();
            String query = "SELECT * FROM tbl_like IN (" + ids + ")";
            ResultSet objResultSet = objConexion.ejecutar(query);
            while (objResultSet.next()) {
                Like obj = new Like();
                int like_id = objResultSet.getInt("like_id");
                obj.setLike_id(like_id);

                int video_id = objResultSet.getInt("video_id");
                obj.setVideo_id(video_id);

                int user_id = objResultSet.getInt("user_id");
                obj.setUser_id(user_id);

                boolean like_status = objResultSet.getBoolean("like_status");
                obj.setLike_status(like_status);

                commentList.add(obj);
            }
        } catch (Exception ex) {
            ;
        }
        return commentList;
    }

}
