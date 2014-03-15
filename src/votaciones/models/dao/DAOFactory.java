package votaciones.models.dao;

import votaciones.models.dao.jpa.JPADAOFactory;

public abstract class DAOFactory {
    // Sera mejor por inyeccion de objetos
    private static DAOFactory factory = new JPADAOFactory();

    public static DAOFactory getFactory() {
        return factory;
    }

    public abstract VotoDAO getVotoDAO();

}
