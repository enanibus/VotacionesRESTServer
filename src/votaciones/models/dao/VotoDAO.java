package votaciones.models.dao;

import java.util.List;

import votaciones.models.entities.Voto;

public interface VotoDAO extends TransactionGenericDAO<Voto, Integer> {
	public List<Voto> getByLevel(int level);
}
