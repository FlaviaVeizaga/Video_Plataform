package factory;

import dal.Configuracion;
import dao.*;

/**
 *
 * @author Flavia Veizaga
 */
public abstract class FactoryDao {

    protected static FactoryDao instancia;

    public static FactoryDao getFactoryInstance() {
        if (instancia == null) {
            Configuracion config = Configuracion.getConfiguracion();
            if (config.getDbEngine().equals("SqlServer"));
            instancia = FactoryDaoSqlServer.getFactoryInstance();
        }
        return instancia;
    }

    public abstract DaoUser getNewDaoUser();

    public abstract DaoVideo getNewDaoVideo();

    public abstract DaoComment getNewDaoComment();

    public abstract DaoLike getNewDaoLike();

}
