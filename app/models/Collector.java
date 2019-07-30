package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Collector
{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int CollectorId;
    private String userName;
    private String password;

    public int getCollectorId()
    {
        return CollectorId;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
}
