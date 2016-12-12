package controllers;

import play.mvc.Result;
import play.mvc.Security;
import views.html.*;

import static play.mvc.Results.ok;

/**
 * Created by midwife123 on 21/12/2015.
 */

@Security.Authenticated(Secured.class)
public class IndexController {
    public static Result dashboard() {
        return ok(dashboard.render());
    }
}
