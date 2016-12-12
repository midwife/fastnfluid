package controllers;

import controllers.backend.UserAccountBE;
import play.*;
import play.data.Form;
import play.mvc.*;
import views.html.*;
import play.api.i18n.Messages;
import models.*;

import java.util.LinkedList;

@Security.Authenticated(Secured.class)
public class Application extends Controller {

    public Result index() {
        String username = request().username();
        UserAccount user = UserAccountBE.getUserFromUsername(username);
        return ok(index.render(username, "Fast & Fluid / Transport Management System", user.getProfileStr() ));
    }
}
