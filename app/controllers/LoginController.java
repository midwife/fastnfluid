package controllers;

import controllers.backend.AccountBE;
import controllers.backend.SocietyBE;
import controllers.backend.UserAccountBE;
import models.UserAccount;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

import views.html.*;

/**
 * Created by MUSIQUE on 29/11/2015.
 */
public class LoginController extends Controller {
    public Result login() {
        UserAccount user = new UserAccount();
        Form<UserAccount> userForm = Form.form(UserAccount.class);

        return ok(login.render("Identification", userForm));
    }

    public Result authenticate() {
        AccountBE.loadFromFixture();
        UserAccountBE.loadFromFixtures();
        //SocietyBE.loadFromFixtures();

        UserAccount user = Form.form(UserAccount.class).bindFromRequest().get();

        Form<UserAccount> userForm = Form.form(UserAccount.class);
        userForm.fill(user);

        //return ok(login.render(user.getUsername(), userForm));

        if (UserAccountBE.Exists(user)) {
            session("username",user.getUsername());
            return redirect(routes.Application.index());
        } else {
            System.out.println("User "+user.getUsername()+" not found");
            session().clear();
            return redirect(routes.LoginController.login());
        }
    }

    public Result logout() {
        session().clear();
        return redirect(routes.LoginController.login());
    }
}
