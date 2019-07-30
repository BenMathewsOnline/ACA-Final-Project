package controllers;

import models.Collector;
import models.CollectorRepository;
import play.data.DynamicForm;
import play.data.FormFactory;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;

public class SessionsController extends Controller
{
    private FormFactory formFactory;
    private CollectorRepository collectorRepository;

    @Inject
    public SessionsController(FormFactory formFactory, CollectorRepository collectorRepository)
    {
        this.formFactory = formFactory;
        this.collectorRepository = collectorRepository;
    }

    public Result getLogin()
    {
        return ok(views.html.Login.render());
    }

    @Transactional
    public Result postLogin()
    {
        DynamicForm form = formFactory.form().bindFromRequest();
        String username = form.get("email");
        String password = form.get("password");
        Collector collector = collectorRepository.getCollector(username, password);

        if (collector == null)
        {
            return ok("FAIL!");
        }
        else
        {
            return ok("Welcome " + collector.getUserName());
        }
    }
}

