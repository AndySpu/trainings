package persistence;

import persistence.model.Master;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Stateless
public class BaseRepositoryImpl implements BaseRepository {

    @PersistenceContext(unitName="PERSISTENCE")
    private EntityManager entityManager;

    public List<Master> findAllOrderedByName() {
        String sql = "from Master";
        return entityManager.createQuery(sql, Master.class).getResultList();
    }


}
