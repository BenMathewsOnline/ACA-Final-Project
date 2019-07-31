package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Amiibo
{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int amiiboId;
    private String amiiboName;
    private String imageId;
    private int gameId;
    private int productTypeId;

    public int getAmiiboId()
    {
        return amiiboId;
    }

    public String getAmiiboName()
    {
        return amiiboName;
    }

    public String getImageId()
    {
        return imageId;
    }

    public int getGameId()
    {
        return gameId;
    }

    public int getProductTypeId()
    {
        return productTypeId;
    }

    public void setAmiiboId(int amiiboId)
    {
        this.amiiboId = amiiboId;
    }

    public void setAmiiboName(String amiiboName)
    {
        this.amiiboName = amiiboName;
    }

    public void setImageId(String imageId)
    {
        this.imageId = imageId;
    }

    public void setGameId(int gameId)
    {
        this.gameId = gameId;
    }

    public void setProductTypeId(int productTypeId)
    {
        this.productTypeId = productTypeId;
    }
}
