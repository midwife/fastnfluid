package controllers;

import controllers.backend.UserAccountBE;
import models.UserAccount;
import play.data.Form;
import play.mvc.*;
import views.html.*;

/**
 * Created by MUSIQUE on 16/03/2016.
 */

public class UserController extends Controller {
  private UserAccount user;

  public Result edit( int id ) {
    UserAccount user = UserAccountBE.getUser(id);

    Form<UserAccount> userForm = Form.form(UserAccount.class).fill(user);

    return ok(user_edit.render("anonymous user", "UserAccount Account Edition", userForm));
  }

  public Result save() {
    UserAccount user = Form.form(UserAccount.class).bindFromRequest().get();

    Form<UserAccount> userForm = Form.form(UserAccount.class);

    //user.setPassword("");
    userForm.fill(user);

    return ok(login.render("Identification",userForm));
  }

}
