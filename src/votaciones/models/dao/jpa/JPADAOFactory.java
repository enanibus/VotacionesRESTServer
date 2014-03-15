package votaciones.models.dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;


import votaciones.models.dao.DAOFactory;
import votaciones.models.dao.VotoDAO;

public class JPADAOFactory extends DAOFactory {
    private static final String PERSISTENCE_UNIT = "VotacionesJPA";

    private EntityManager em;

    public JPADAOFactory() {
        this.em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT).createEntityManager();
    }

    public EntityManager getEm() {
        if (!em.isOpen())
            this.em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT)
                    .createEntityManager();
        return em;
    }

    @Override
    public VotoDAO getVotoDAO() {
        return new JPAVotoDAO();
    }

}
