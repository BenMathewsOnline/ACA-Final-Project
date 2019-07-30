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

    public List<Amiibo> getFigureList()
    {
        String sql = "SELECT a FROM Amiibo a" +
                "WHERE a ProductTypeId = 1 OR a ProductTypeId = 3";
        TypedQuery<Amiibo> query = jpaApi.em().createQuery(sql, Amiibo.class);
        List<Amiibo> amiibos = query.getResultList();
        return amiibos;
    }

    public List<Amiibo> getCardList()

    {
        String sql = "SELECT a FROM Amiibo a" +
                "WHERE ProductTypeId = 2";
        TypedQuery<Amiibo> query = jpaApi.em().createQuery(sql, Amiibo.class);
        List<Amiibo> amiiboCard = query.getResultList();
        return amiiboCard;
    }

    public List<Amiibo> getFigure(String searchName)
    {
        String searchValue = searchName;

        if (searchValue == null)
        {
            searchValue = "";
        }
        if (searchValue.length() <= 1)
        {
            searchValue = searchValue + "%";
        } else
        {
            searchValue = "%" + searchValue + "%";
        }

        String sql = "SELECT a " +
                "FROM Amiibo a " +
                "WHERE amiiboName LIKE :searchName " +
                "AND ProductTypeId != 2 " +
                "ORDER BY a.amiiboName";
        TypedQuery<Amiibo> query = jpaApi.em().createQuery(sql, Amiibo.class);
        query.setParameter("searchName", searchValue);
        List<Amiibo> amiibos = query.getResultList();
        return amiibos;
    }

    public List<Amiibo> getCard(String searchName)
    {
        String searchValue = searchName;

        if (searchValue == null)
        {
            searchValue = "";
        }
        if (searchValue.length() <= 1)
        {
            searchValue = searchValue + "%";
        } else
        {
            searchValue = "%" + searchValue + "%";
        }

        String sql = "SELECT a " +
                "FROM Amiibo a " +
                "WHERE amiiboName LIKE :searchName " +
                "AND ProductTypeId = 2 " +
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
