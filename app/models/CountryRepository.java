package models;

import play.db.jpa.JPAApi;
import javax.inject.Inject;
import javax.persistence.TypedQuery;
import java.util.List;

public class CountryRepository
{
    private JPAApi jpaApi;

    @Inject
    public CountryRepository (JPAApi jpaApi)
    {
        this.jpaApi = jpaApi;
    }

    public List<Country> getList()
    {
        String sql = "SELECT countryName FROM country";
        TypedQuery<Country> query = jpaApi.em().createQuery(sql, Country.class);
        List<Country> countries = query.getResultList();
        return countries;
    }

    public Country get(int countryId)
    {
        int searchValue = countryId;

        if (searchValue == 0 || searchValue > 4)
        {
            System.out.println("Enter number between 1 and 4");
        }
        else
        {
            searchValue = searchValue;
        }

        String sql = "SELECT c FROM Country c WHERE CountryId = :CountryId";
        TypedQuery<Country> query = jpaApi.em().createQuery(sql, Country.class);
        query.setParameter("CountryId", countryId);
        Country country = query.getSingleResult();
        return country;
    }

}
