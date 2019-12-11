package dal;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * @author Flavia Veizaga
 */
public class ConexionSqlServer extends Conexion {

    public static Conexion getOrCreate(){
        if(objSingleton==null)
            objSingleton = new ConexionSqlServer();
        return objSingleton;
    }

    private ConexionSqlServer() {
        Configuracion objConfiguracion =
                Configuracion.getConfiguracion();
        this.host = objConfiguracion.getDbHost();
        this.dataBase = objConfiguracion.getDbName();
        this.instance = objConfiguracion.getDbInstace();
        this.port = objConfiguracion.getDbPort();
        this.userName = objConfiguracion.getDbUser();
        this.password = objConfiguracion.getDbPassword();
    }

    @Override
    public void conectar() {
        if (this.estaConectado()) {
        } else {
            try {
                Class.forName("com.sqlserver.jdbc.SQLServerDriver").newInstance();
            } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            }
            try {
                String sUrl = "jdbc:sqlserver://" + this.host + "/" + this.dataBase;
                System.out.println(sUrl);
                objConnection = DriverManager.getConnection(sUrl, userName, password);
            } catch (SQLException e) {
            }
        }

    }

    @Override
    public void comenzarTransaccion() {
        if (!this.estaConectado()) {
            this.conectar();
        }

        try {
            objConnection.setAutoCommit(false);
        } catch (SQLException e) {
        }
    }

    @Override
    public void terminarTransaccion() {
        try {
            objConnection.commit();
        } catch (SQLException e) {
        }
    }

    @Override
    public void desconectar() {
        try {
            if (this.estaConectado()) {
                objConnection.close();
            }
        } catch (SQLException e) {
        }
    }

    @Override
    public ResultSet ejecutar(String query) {
        try {
            Statement stmt = objConnection.createStatement();
            ResultSet res = stmt.executeQuery(query);
            return res;
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public boolean estaConectado() {
        if (this.objConnection == null) {
            return false;
        }
        try {
            if (this.objConnection.isClosed()) {
                return false;
            }
        } catch (SQLException e) {
            this.objConnection = null;
            return false;
        }
        return true;
    }

    @Override
    public int ejecutarSimple(String query) {
        try {
            Statement stmt = objConnection.createStatement();
            int nb = stmt.executeUpdate(query);
            return nb;
        } catch (SQLException e) {
            return 0;
        }
    }

    @Override
    public int ejecutarInsert(String query) {
        try {
            Statement stmt = objConnection.createStatement();
            stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            return 0;
        }
    }
}
