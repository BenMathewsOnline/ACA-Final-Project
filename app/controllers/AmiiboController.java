package controllers;

import models.Amiibo;
import models.AmiiboCollection;
import models.AmiiboCollectionRepository;
import models.AmiiboRepository;
import play.data.DynamicForm;
import play.data.FormFactory;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import javax.inject.Inject;
import java.util.Collection;
import java.util.List;

public class AmiiboController extends Controller
{
    private FormFactory formFactory;
    private AmiiboRepository amiiboRepository;
    private AmiiboCollectionRepository amiiboCollectionRepository;

    @Inject
    public AmiiboController (FormFactory formFactory, AmiiboRepository amiiboRepository, AmiiboCollectionRepository amiiboCollectionRepository)
    {
        this.formFactory = formFactory;
        this.amiiboRepository = amiiboRepository;
        this.amiiboCollectionRepository = amiiboCollectionRepository;
    }

    @Transactional(readOnly = true)
    public Result getFigureList()
    {
        DynamicForm form = formFactory.form().bindFromRequest();
        String searchName = form.get("searchName");
        List<Amiibo> character = amiiboRepository.getFigure(searchName);
        String userName = session().get("userName");
        //on the line below, the two parameters after render refer to what you pass to the views,
        // so @(amiibos : List[Amiibo], userName: String)
        return ok(views.html.Amiibo.render(character, userName));
    }

    @Transactional(readOnly = true)
    public Result getCardList()
    {
        DynamicForm form = formFactory.form().bindFromRequest();
        String searchName = form.get("searchName");
        List<Amiibo> character = amiiboRepository.getCard(searchName);
        String userName = session().get("userName");
        return ok(views.html.AmiiboCards.render(character, userName));
    }

    public Result getAboutAmiibo()
    {
        String userName = session().get("userName");
        return ok(views.html.AboutAmiibo.render(userName));
    }

    public Result getHome()
    {
        String userName = session().get("userName");
        return ok(views.html.Home.render(userName));
    }

    @Transactional
    public Result getCollection()
    {
        DynamicForm form = formFactory.form().bindFromRequest();
        String searchName = form.get("searchName");
        List<Amiibo> character = amiiboRepository.getCard(searchName);
        String userName = session().get("userName");
        return ok(views.html.MyCollection.render(character, userName));
    }

 /*   @Transactional
    public Result getMyCollection()
    {
        DynamicForm form = formFactory.form().bindFromRequest();
        String email = form.get("email");
        Collection collection = amiiboCollectionRepository.getAmiiboCollectionList(email);

        if (collection == null)
        {
            return ok("Please try entering a your username and password again.");
        }
        else
        {
            session().put("email", collection.
            return redirect(routes.AmiiboController.getCollection());
        }
        //get collectorId from session, get amiibo rows based on collectorid,
        //join amiio table (done), and finally send list of amiibo to view
    }*/
}
