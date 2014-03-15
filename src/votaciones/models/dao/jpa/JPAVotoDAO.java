package votaciones.models.dao.jpa;

import java.util.List;

import javax.persistence.Query;

import votaciones.models.dao.VotoDAO;
import votaciones.models.entities.Voto;

public class JPAVotoDAO extends JPATransactionGenericDAO<Voto, Integer> implements VotoDAO {

	public JPAVotoDAO() {
		super(Voto.class);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Voto> getByLevel(int level) {
		Query query = em.createNamedQuery("getByLevel");
		query.setParameter("level", level);
		List<?> res = query.getResultList();
		return (List<Voto>) res;
	}

}
