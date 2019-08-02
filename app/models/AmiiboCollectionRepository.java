package models;

import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import javax.inject.Inject;
import javax.persistence.TypedQuery;
import java.util.Collection;
import java.util.List;

public class AmiiboCollectionRepository extends Collector
{
    private JPAApi jpaApi;
    private AmiiboCollection amiiboCollection;

    @Inject
    public AmiiboCollectionRepository(JPAApi jpaApi, AmiiboCollection amiiboCollection)
    {
        this.jpaApi = jpaApi;
        this.amiiboCollection = amiiboCollection;
    }

    public List<Collection> getAmiiboCollectionList(int collectorId)
    {
        String sql = "SELECT a FROM AmiiboCollection a " +
                "WHERE CollectorId = :CollectorId";
        TypedQuery<Collection> query = jpaApi.em().createQuery(sql, Collection.class);
        query.setParameter("CollectorId", collectorId);
        List<Collection> collections = query.getResultList();
        return collections;
    }

    @Transactional
    public void add(Collection collection)
    {
        jpaApi.em().persist(collection);
    }



}
