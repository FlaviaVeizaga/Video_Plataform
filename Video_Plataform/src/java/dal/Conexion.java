package dal;

import java.sql.Connection;

/*
 * @author Flavia Veizaga
 */
public abstract class Conexion implements IConexion {

    protected String host;

    protected String dataBase;

    protected String instance;

    protected String port;

    protected String userName;

    protected String password;

    protected Connection objConnection;

    protected static Conexion objSingleton;

    public static Conexion getOrCreate() {
        if (objSingleton == null) {
            Configuracion config = Configuracion.getConfiguracion();
            if (objSingleton == null) {
                if (config.getDbEngine().equals("SQLServer")) {
                    objSingleton = ConexionSqlServer.getOrCreate();
                }
            }
        }
        objSingleton.conectar();
        return objSingleton;
    }

    public String getDataBase() {
        return dataBase;
    }

    public String getHost() {
        return host;
    }

    public String getInstance() {
        return instance;
    }

    public String getPassword() {
        return password;
    }

    public String getPort() {
        return port;
    }

    public String getUsername() {
        return userName;
    }
}
