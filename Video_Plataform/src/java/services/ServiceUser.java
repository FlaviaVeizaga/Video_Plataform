package services;

import dao.DaoUser;
import dto.User;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("usuario")
public class ServiceUser {

    // api/usuario/login
    @Path("login")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Respuesta login(User param) {
        Respuesta respuesta = new Respuesta();
        try {
            DaoUser dao = factory.FactoryDao.getFactoryInstance().getNewDaoUser();
            User objUsuario = dao.get(param.getUser_id());
            if (objUsuario != null && objUsuario.getUser_password().equals(param.getUser_password())) {
                respuesta.setEsOk(true);
                String jsonData = "{"
                        + "\"fullName\" : \"" + objUsuario.getUser_fullname() + "\","
                        + "\"userName\" : \"" + objUsuario.getUser_name() + "\","
                        + "\"userId\" :  " + objUsuario.getUser_id()
                        + "}";
                respuesta.setMensaje(jsonData);
            } else {
                respuesta.setMensaje("Usuario y/o contraseña son incorrectos");
            }

        } catch (Exception e) {
            respuesta.setMensaje("Error de autenticacion");
        }
        return respuesta;

    }
}
