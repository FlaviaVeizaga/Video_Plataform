/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.DaoVideo;
import dto.Video;
import factory.FactoryDao;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Flavia Veizaga
 */
@Path("video")
public class ServiceVideo {
    
    @Path("/")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Video> getVideos(@QueryParam("ids")String ids){
        try {
            
            DaoVideo dao = FactoryDao.getFactoryInstance().getNewDaoVideo();
            return ids == null  ? dao.getList() : dao.getListFromIds(ids);
        } catch (Exception e) {
        }
        return null;
    }
    
    @Path("/{video_id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Video  getVideoById(@PathParam("video_id") int video_id){
        try {
            DaoVideo dao = FactoryDao.getFactoryInstance().getNewDaoVideo();
            return dao.get(video_id);
        } catch (Exception e) {
        }
        return null;
    }
    
    @Path("/")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Respuesta insertar(Video obj){
        Respuesta resultado = new Respuesta();
        try {
            DaoVideo dao = FactoryDao.getFactoryInstance().getNewDaoVideo();
            dao.insert(obj);
            resultado.setEsOk(true);
        } catch (Exception e) {
            resultado.setEsOk(false);
            resultado.setMensaje("Error al crear contacto");
        }
        return resultado;
    }
    
    @Path("/")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Respuesta actualizar(Video obj){
        Respuesta resultado = new Respuesta();
        try {
            DaoVideo dao = FactoryDao.getFactoryInstance().getNewDaoVideo();
            dao.update(obj);
            resultado.setEsOk(true);
        } catch (Exception e) {
            resultado.setEsOk(false);
            resultado.setMensaje("Error al actualizar contacto");
        }
        return resultado;
    }
    
    @Path("/{video_id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Respuesta delete(@PathParam("video_id") int video_id){
        Respuesta respuesta = new Respuesta();
        try {
            DaoVideo dao = FactoryDao.getFactoryInstance().getNewDaoVideo();
            dao.delete(video_id);
            respuesta.setEsOk(true);
        } catch (Exception e) {
            respuesta.setEsOk(false);
            respuesta.setMensaje("Error al eliminar el contacto");
        }
        return respuesta;
    }
}
