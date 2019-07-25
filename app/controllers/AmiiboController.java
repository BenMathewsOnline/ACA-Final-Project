package controllers;

import models.Amiibo;
import models.AmiiboRepository;
import models.Country;
import models.CountryRepository;
import play.data.DynamicForm;
import play.data.FormFactory;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.List;

public class AmiiboController extends Controller
{
    private FormFactory formFactory;
    private AmiiboRepository amiiboRepository;
    private CountryRepository countryRepository;

    @Inject
    public AmiiboController (FormFactory formFactory, AmiiboRepository amiiboRepository, CountryRepository countryRepository)
    {
        this.formFactory = formFactory;
        this.amiiboRepository = amiiboRepository;
        this.countryRepository = countryRepository;
    }

    @Transactional(readOnly = true)
    public Result getList()
    {
        DynamicForm form = formFactory.form().bindFromRequest();
        String searchName = form.get("SearchName");
        List<Amiibo> character = amiiboRepository.get(searchName);
        return ok(views.html.Amiibo.render(character));
    }

    
}
