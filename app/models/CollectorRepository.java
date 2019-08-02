package models;
import play.db.jpa.JPAApi;
import javax.inject.Inject;
import javax.persistence.TypedQuery;
import java.util.List;

public class CollectorRepository
{
    private JPAApi jpaApi;

    @Inject
    CollectorRepository(JPAApi jpaApi)
    {
        this.jpaApi = jpaApi;
    }

    public void add(Collector collector)
    {
        jpaApi.em().persist(collector);
    }

    public Collector getCollector(String email, String password)
    {
        String sql = "SELECT c FROM Collector c WHERE userName = :email AND password = :password";

        System.out.println(sql);
        TypedQuery<Collector> query = jpaApi.em().createQuery(sql, Collector.class);
        query.setParameter("email", email);
        query.setParameter("password", password);
        List<Collector> collectors = query.getResultList();
        if (collectors.size() == 0)
        {
            return null;
        }
        else
        {
            return collectors.get(0);
        }
    }
}
