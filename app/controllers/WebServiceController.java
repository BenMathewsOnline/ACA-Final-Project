package controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.Amiibo;
import models.AmiiboCountry;
import models.AmiiboRepository;
import models.amiibo.AmiiboList;
import play.Logger;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import com.typesafe.config.Config;
import play.mvc.Result;

import javax.inject.Inject;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;

public class WebServiceController extends Controller
{
    private Config config;
    private AmiiboRepository amiiboRepository;

    @Inject
    public WebServiceController(Config config, AmiiboRepository amiiboRepository)
    {
        this.config = config;
        this.amiiboRepository = amiiboRepository;
    }

    @Transactional
    public Result getAmiiboData()
    {
        ArrayList<Long> volumes = new ArrayList<>();
        String nodeName = "";
        String apiKey = config.getString("apikeys.alphavantage");
        Logger.debug("KEY " + apiKey);
        AmiiboList amiiboList = null;

        try
        {
            URL url = new URL("https://www.amiiboapi.com/api/amiibo/");

            ObjectMapper objectMapper = new ObjectMapper();
            amiiboList = objectMapper.readValue(url, AmiiboList.class);

        } catch (Exception e)
        {
            Logger.error(e.getMessage());
        }
        for (models.amiibo.Amiibo amiiboEntry : amiiboList.getAmiibo())
        {
            Amiibo amiibo = new Amiibo();
            amiibo.setAmiiboName(amiiboEntry.getName());

            switch (amiiboEntry.getType())
            {
                case "Figure":
                    amiibo.setProductTypeId(1);
                    break;
                case "Card":
                    amiibo.setProductTypeId(2);
                    break;
                case "Yarn":
                    amiibo.setProductTypeId(3);
                    break;
            }

            switch (amiiboEntry.getGameSeries())
            {
                case "Super Smash Bros.":
                    amiibo.setGameId(1);
                    break;
                case "Super Mario Bros.":
                    amiibo.setGameId(2);
                    break;
                case "Yoshi's Woolly World":
                    amiibo.setGameId(3);
                    break;
                case "Legend Of Zelda":
                    amiibo.setGameId(4);
                    break;
                case "Animal Crossing":
                    amiibo.setGameId(5);
                    break;
                case "Metroid":
                    amiibo.setGameId(6);
                    break;
                case "Splatoon":
                    amiibo.setGameId(7);
                    break;
                case "Mario Sports Superstars":
                    amiibo.setGameId(8);
                    break;
                case "Pokemon":
                    amiibo.setGameId(9);
                    break;
                case "Kirby":
                    amiibo.setGameId(10);
                    break;
                case "Fire Emblem":
                    amiibo.setGameId(11);
                    break;
                case "Monster Hunter":
                    amiibo.setGameId(12);
                    break;
                case "Shovel Knight":
                    amiibo.setGameId(13);
                    break;
                default:
                    amiibo.setGameId(14);
                    break;
            }

            amiiboRepository.add(amiibo);

            if (amiiboEntry.getRelease().getAu() != null)
            {
                LocalDate date = LocalDate.parse(amiiboEntry.getRelease().getAu());
                AmiiboCountry amiiboCountry = new AmiiboCountry();
                amiiboCountry.setAmiiboId(amiibo.getAmiiboId());
                amiiboCountry.setCountryId(1);
                amiiboCountry.setReleaseDate(date);
                amiiboRepository.addAmiiboCountry(amiiboCountry);
            }
            if (amiiboEntry.getRelease().getEu() != null)
            {
                LocalDate date = LocalDate.parse(amiiboEntry.getRelease().getEu());
                AmiiboCountry amiiboCountry = new AmiiboCountry();
                amiiboCountry.setAmiiboId(amiibo.getAmiiboId());
                amiiboCountry.setCountryId(2);
                amiiboCountry.setReleaseDate(date);
                amiiboRepository.addAmiiboCountry(amiiboCountry);
            }
            if (amiiboEntry.getRelease().getJp() != null)
            {
                LocalDate date = LocalDate.parse(amiiboEntry.getRelease().getJp());
                AmiiboCountry amiiboCountry = new AmiiboCountry();
                amiiboCountry.setAmiiboId(amiibo.getAmiiboId());
                amiiboCountry.setCountryId(3);
                amiiboCountry.setReleaseDate(date);
                amiiboRepository.addAmiiboCountry(amiiboCountry);
            }
            if (amiiboEntry.getRelease().getNa() != null)
            {
                LocalDate date = LocalDate.parse(amiiboEntry.getRelease().getNa());
                AmiiboCountry amiiboCountry = new AmiiboCountry();
                amiiboCountry.setAmiiboId(amiibo.getAmiiboId());
                amiiboCountry.setCountryId(4);
                amiiboCountry.setReleaseDate(date);
                amiiboRepository.addAmiiboCountry(amiiboCountry);
            }
        }

        return ok("hi there " + amiiboList.getAmiibo().size());
    }
}
