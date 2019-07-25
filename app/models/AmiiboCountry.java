package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class AmiiboCountry
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int amiiboCountryId;
    int amiiboId;
    int countryId;
    LocalDate releaseDate;

    public void setAmiiboId(int amiiboId)
    {
        this.amiiboId = amiiboId;
    }

    public void setCountryId(int countryId)
    {
        this.countryId = countryId;
    }

    public void setReleaseDate(LocalDate releaseDate)
    {
        this.releaseDate = releaseDate;
    }
}
