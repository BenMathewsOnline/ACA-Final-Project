package models;

import play.db.jpa.JPAApi;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.TypedQuery;

public class AmiiboRepository
{
    private JPAApi jpaApi;

    @Inject
    public AmiiboRepository(JPAApi jpaApi)
    {
        this.jpaApi = jpaApi;
    }

    public List<Amiibo> getList()
    {
        String sql = "SELECT a FROM Amiibo a";
        TypedQuery<Amiibo> query = jpaApi.em().createQuery(sql, Amiibo.class);
        List<Amiibo> amiibos = query.getResultList();
        return amiibos;
    }

    public List<Amiibo> get(String searchName)
    {
        String searchValue = searchName;

        if (searchValue == null)
        {
            searchValue = "";
        }
        if (searchValue.length() <= 1)
        {
            searchValue = searchValue + "%";
        }
        else
        {
            searchValue = "%" + searchValue + "%";
        }

        String sql = "SELECT a " +
                "FROM Amiibo a " +
                "WHERE amiiboName LIKE :searchName " +
                "ORDER BY a.amiiboName";
        TypedQuery<Amiibo> query = jpaApi.em().createQuery(sql, Amiibo.class);
        query.setParameter("searchName", searchValue);
        List<Amiibo> amiibos = query.getResultList();
        return amiibos;
    }

    public void add(Amiibo amiibo)
    {
        jpaApi.em().persist(amiibo);
    }

    public void addAmiiboCountry(AmiiboCountry amiiboCountry)
    {
        jpaApi.em().persist(amiiboCountry);
    }

}
