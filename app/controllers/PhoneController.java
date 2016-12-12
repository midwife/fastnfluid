package controllers;

import controllers.backend.AccountBE;
import controllers.backend.UserAccountBE;
import models.UserAccount;
import play.mvc.*;
import views.html.*;

/**
 * Created by midwife123 on 24/03/2016.
 */

@Security.Authenticated(Secured.class)
public class PhoneController extends Controller {
  public Result index() {
    String username = request().username();

    AccountBE.loadFromFixture();
    UserAccountBE.loadFromFixtures();

    UserAccount user = UserAccountBE.getUserFromUsername(username);
    String userType = user.getProfileStr();

    System.out.println("/// * userType : "+userType);

    return ok(phone.render(username, "Fast & Fluid / Transport Management System", userType ));
  }
}
