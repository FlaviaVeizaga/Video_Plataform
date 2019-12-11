package dao;

import dal.Conexion;
import dto.Comment;
import java.sql.ResultSet;
import java.util.ArrayList;

/*
 * @author Flavia Veizaga
 */
public class DaoCommentSqlServer extends DaoComment {

    @Override
    public int insert(Comment obj) throws Exception {
        Conexion objConexion = Conexion.getOrCreate();

        int id = 0;
        StringBuilder query = new StringBuilder("INSERT INTO tbl_comentario VALUES (");
        query.append("'").append(obj.getComment_id()).append("',");
        query.append("'").append(obj.getComment_body()).append("',");
        query.append("'").append(obj.getUser_id()).append("',");
        query.append("'").append(obj.getVideo_id()).append("' ");
        query.append(")");

        id = objConexion.ejecutarInsert(query.toString());
        if (id == 0) {
            throw new Exception("El registro no pudo ser insertado");
        }
        objConexion.desconectar();
        return id;
    }

    @Override
    public void update(Comment obj) throws Exception {
        Conexion objConexion = Conexion.getOrCreate();

        StringBuilder query = new StringBuilder("UPDATE tbl_comentario SET ");
        query.append("'").append(obj.getComment_body()).append("',");
        query.append("'").append(obj.getUser_id()).append("',");
        query.append("'").append(obj.getVideo_id()).append("' ");
        query.append("WHERE contactoId = ").append(obj.getComment_id());
        int upd = objConexion.ejecutarSimple(query.toString());
        if (upd == 0) {
            throw new Exception("El registro no pudo ser actualizado");
        }

        objConexion.desconectar();
    }

    @Override
    public void delete(int id) {
        Conexion objConexion = Conexion.getOrCreate();
        StringBuilder query = new StringBuilder("DELETE FROM tbl_comentario ");
        query.append("WHERE comment_id = ").append(id);
        objConexion.ejecutarSimple(query.toString());
        objConexion.desconectar();
    }

    @Override
    public ArrayList<Comment> getList() {
        ArrayList<Comment> commentList = new ArrayList<>();
        try {
            Conexion objConexion = Conexion.getOrCreate();
            String query = "SELECT * FROM tbl_comentario";
            ResultSet objResultSet = objConexion.ejecutar(query);
            while (objResultSet.next()) {
                Comment obj = new Comment();
                int comment_id = objResultSet.getInt("comment_id");
                obj.setComment_id(comment_id);

                String comment_body = objResultSet.getString("comment_body");
                obj.setComment_body(comment_body);

                int video_id = objResultSet.getInt("video_id");
                obj.setVideo_id(video_id);

                int user_id = objResultSet.getInt("user_id");
                obj.setUser_id(user_id);

                commentList.add(obj);
            }
        } catch (Exception ex) {
            ;
        }
        return commentList;
    }

    @Override
    public Comment get(int id) {
        try {
            Conexion objConexion = Conexion.getOrCreate();
            String query = "SELECT * FROM tbl_comentario WHERE comment_id = " + id;
            ResultSet objResultSet = objConexion.ejecutar(query);
            if (objResultSet.next()) {
                Comment obj = new Comment();
                int comment_id = objResultSet.getInt("comment_id");
                obj.setComment_id(comment_id);

                String comment_body = objResultSet.getString("comment_body");
                obj.setComment_body(comment_body);

                int video_id = objResultSet.getInt("video_id");
                obj.setVideo_id(video_id);

                int user_id = objResultSet.getInt("user_id");
                obj.setUser_id(user_id);

                return obj;
            }
        } catch (Exception ex) {
            ;
        }
        return null;
    }

    @Override
    public ArrayList<Comment> getListFromIds(String ids) {
        ArrayList<Comment> commentList = new ArrayList<>();
        if (ids == null || ids.trim().isEmpty()) {
            ids = "0";
        }
        try {
            Conexion objConexion = Conexion.getOrCreate();
            String query = "SELECT * FROM tbl_comentario IN (" + ids + ")";
            ResultSet objResultSet = objConexion.ejecutar(query);
            while (objResultSet.next()) {
                Comment obj = new Comment();
                int comment_id = objResultSet.getInt("comment_id");
                obj.setComment_id(comment_id);

                String comment_body = objResultSet.getString("comment_body");
                obj.setComment_body(comment_body);

                int video_id = objResultSet.getInt("video_id");
                obj.setVideo_id(video_id);

                int user_id = objResultSet.getInt("user_id");
                obj.setUser_id(user_id);

                commentList.add(obj);
            }
        } catch (Exception ex) {
            ;
        }
        return commentList;
    }

}
