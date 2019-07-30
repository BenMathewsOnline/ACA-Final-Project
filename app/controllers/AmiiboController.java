package controllers;

import models.Amiibo;
import models.AmiiboRepository;
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

    @Inject
    public AmiiboController (FormFactory formFactory, AmiiboRepository amiiboRepository)
    {
        this.formFactory = formFactory;
        this.amiiboRepository = amiiboRepository;
    }

    @Transactional(readOnly = true)
    public Result getFigureList()
    {
        DynamicForm form = formFactory.form().bindFromRequest();
        String searchName = form.get("searchName");
        List<Amiibo> character = amiiboRepository.getFigure(searchName);
        return ok(views.html.Amiibo.render(character));
    }

    @Transactional(readOnly = true)
    public Result getCardList()
    {
        DynamicForm form = formFactory.form().bindFromRequest();
        String searchName = form.get("searchName");
        List<Amiibo> character = amiiboRepository.getCard(searchName);
        return ok(views.html.AmiiboCards.render(character));
    }

    public Result getAboutAmiibo()
    {
        return ok(views.html.AboutAmiibo.render());
    }

    public Result getHome()
    {
        return ok(views.html.Home.render());
    }

    public Result getCollection()
    {
        return ok(views.html.MyCollection.render());
    }
}
