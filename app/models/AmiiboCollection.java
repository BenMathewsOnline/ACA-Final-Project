package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AmiiboCollection
{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int amiiboCollectionId;
    private int amiiboID;
    private int collectorId;

    public int getAmiiboCollectionId()
    {
        return amiiboCollectionId;
    }

    public int getAmiiboID()
    {
        return amiiboID;
    }

    public void setAmiiboID(int amiiboID)
    {
        this.amiiboID = amiiboID;
    }

    public int getCollectorId()
    {
        return collectorId;
    }

    public void setCollectorId(int collectorId)
    {
        this.collectorId = collectorId;
    }
}
