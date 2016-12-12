package controllers;

import java.security.Security;
import play.*;
import static play.mvc.Results.redirect;
import play.mvc.*;
import play.mvc.Http.*;

import models.*;

/**
 * Created by MUSIQUE on 29/11/2015.
 */
public class Secured extends play.mvc.Security.Authenticator {
    @Override
    public String getUsername (Context ctx) {
        return ctx.session().get("username");
    }

    @Override
    public Result onUnauthorized (Context ctx) {
        return redirect(routes.LoginController.login());
    }
}
