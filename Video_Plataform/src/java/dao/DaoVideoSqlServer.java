package dao;

import dal.Conexion;
import dto.Video;
import java.sql.ResultSet;
import java.util.ArrayList;

/*
 * @author Flavia Veizaga
 */
public class DaoVideoSqlServer extends DaoVideo {

    @Override
    public int insert(Video obj) throws Exception {
        Conexion objConexion = Conexion.getOrCreate();

        int id = 0;
        StringBuilder query = new StringBuilder("INSERT INTO tbl_video VALUES (");
        query.append("'," + "'").append(obj.getVideo_id());
        query.append("'").append(obj.getVideo_id()).append("',");
        query.append("'").append(obj.getVideo_name()).append("',");
        query.append("'").append(obj.getVideo_url()).append("',");
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
    public void update(Video obj) throws Exception {
        Conexion objConexion = Conexion.getOrCreate();

        StringBuilder query = new StringBuilder("UPDATE tbl_video SET ");
        query.append("'").append(obj.getVideo_id()).append("',");
        query.append("'").append(obj.getVideo_name()).append("',");
        query.append("'").append(obj.getVideo_url()).append("',");
        query.append("'").append(obj.getVideo_id()).append("' ");
        int upd = objConexion.ejecutarSimple(query.toString());
        if (upd == 0) {
            throw new Exception("El registro no pudo ser actualizado");
        }

        objConexion.desconectar();
    }

    @Override
    public void delete(int id) {
        Conexion objConexion = Conexion.getOrCreate();
        StringBuilder query = new StringBuilder("DELETE FROM tbl_video ");
        query.append("WHERE video_id = ").append(id);
        objConexion.ejecutarSimple(query.toString());
        objConexion.desconectar();
    }

    @Override
    public ArrayList<Video> getList() {
        ArrayList<Video> userList = new ArrayList<>();
        try {
            Conexion objConexion = Conexion.getOrCreate();
            String query = "SELECT * FROM tbl_video";
            ResultSet objResultSet = objConexion.ejecutar(query);
            if (objResultSet.next()) {
                Video obj = new Video();
                int video_id = objResultSet.getInt("video_id");
                obj.setVideo_id(video_id);

                String video_name = objResultSet.getString("video_name");
                obj.setVideo_name(video_name);

                String video_url = objResultSet.getString("video_url");
                obj.setVideo_url(video_url);

                int user_id = objResultSet.getInt("user_id");
                obj.setVideo_id(user_id);

                userList.add(obj);
            }
        } catch (Exception ex) {
            ;
        }
        return userList;
    }

    @Override
    public Video get(int id) {
        try {
            Conexion objConexion = Conexion.getOrCreate();
            String query = "SELECT * FROM tbl_video WHERE video_id = " + id;
            ResultSet objResultSet = objConexion.ejecutar(query);
            if (objResultSet.next()) {
                Video obj = new Video();
                int video_id = objResultSet.getInt("video_id");
                obj.setVideo_id(video_id);

                String video_name = objResultSet.getString("video_name");
                obj.setVideo_name(video_name);

                String video_url = objResultSet.getString("video_url");
                obj.setVideo_url(video_url);

                int user_id = objResultSet.getInt("user_id");
                obj.setVideo_id(user_id);

                return obj;
            }
        } catch (Exception ex) {
            ;
        }
        return null;
    }

    @Override
    public ArrayList<Video> getListFromIds(String ids) {
        ArrayList<Video> registros = new ArrayList<>();
        if (ids == null || ids.trim().isEmpty()) {
            ids = "0";
        }
        try {
            Conexion objConexion = Conexion.getOrCreate();
            String query = "SELECT * FROM tbl_video WHERE video_id IN (" + ids + ")";
            ResultSet objResultSet = objConexion.ejecutar(query);
            while (objResultSet.next()) {
                Video obj = new Video();
                int video_id = objResultSet.getInt("video_id");
                obj.setVideo_id(video_id);

                String video_name = objResultSet.getString("video_name");
                obj.setVideo_name(video_name);

                String video_url = objResultSet.getString("video_url");
                obj.setVideo_url(video_url);

                int user_id = objResultSet.getInt("user_id");
                obj.setVideo_id(user_id);

                registros.add(obj);
            }
        } catch (Exception ex) {
            ;
        }
        return registros;
    }

}
