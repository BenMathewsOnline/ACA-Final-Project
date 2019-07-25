/* package controllers;

import play.data.DynamicForm;
import play.data.FormFactory;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;

public class SessionsController extends Controller
{
    private FormFactory formFactory;

    @Inject
    public SessionsController(FormFactory formFactory)
    {
        this.formFactory = formFactory;
    }

    public Result getLogin()
    {
        return ok(views.html.Login.render());
    }

    @Transactional
    public Result postLogin()
    {
        DynamicForm form = formFactory.form().bindFromRequest();
        String username = form.get("username");
        String password = form.get("password");
        User user = userRepository.getUser(username, password);

        if (user == null)
        {
            return ok("FAIL!");
        }
        else
        {
            return ok("Welcome " + user.getFirstName());
        }
    }
}
*/
