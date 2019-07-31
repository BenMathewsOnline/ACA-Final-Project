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
            return ok("Please try entering a your username and password again.");
        }
        else
        {
            return ok("Welcome " + collector.getUserName());
        }
    }

    @Transactional ()
    public Result postNewCollector()
    {
        DynamicForm form = formFactory.form().bindFromRequest();

        Collector collector = new Collector();
        String collectorName = form.get("email");
        collector.setUserName(collectorName);

        String newPassword = form.get("new password");
        collector.setPassword(newPassword);
        collectorRepository.add(collector);

        if (collector == null)
        {
            return ok("Please try entering a new username and password again.");
        }
        else
        {
            return ok(views.html.NewUserSuccess.render());
        }
    }
}

