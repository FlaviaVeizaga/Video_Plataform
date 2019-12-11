package factory;

import dao.*;

/**
 *
 * @author Flavia Veizaga
 */
public class FactoryDaoSqlServer extends FactoryDao {

    private FactoryDaoSqlServer() {
        ;
    }

    public static FactoryDao getFactoryInstance() {
        if (instancia == null) {
            instancia = new FactoryDaoSqlServer();
        }
        return instancia;
    }

    @Override
    public DaoUser getNewDaoUser() {
        return new DaoUserSqlServer();
    }

    @Override
    public DaoVideo getNewDaoVideo() {
        return new DaoVideoSqlServer();
    }

    @Override
    public DaoComment getNewDaoComment() {
        return new DaoCommentSqlServer();
    }

    @Override
    public DaoLike getNewDaoLike() {
       return new DaoLikeSqlserver();
    }


}
