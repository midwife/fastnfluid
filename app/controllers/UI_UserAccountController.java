package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import controllers.backend.AccountBE;
import controllers.backend.UserAccountBE;
import models.Account;
import models.UserAccount;
import play.data.Form;
import play.data.FormFactory;
import play.libs.Json;
import play.libs.ws.WSAuthScheme;
import play.libs.ws.WSClient;
import play.libs.ws.WSResponse;
import play.mvc.Result;
import play.mvc.Security;
import scala.Console;
import views.html.*;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.concurrent.CompletionStage;

import static play.mvc.Controller.session;
import static play.mvc.Http.Context.Implicit.request;
import static play.mvc.Results.ok;

/**
 * Created by MUSIQUE on 02/11/2016.
 */

@Security.Authenticated(Secured.class)
public class UI_UserAccountController {

  @Inject
  FormFactory formFactory;
  @Inject
  WSClient ws;

  private String actualUsername;

  public Result showUserAccount (int id) {

    this.actualUsername = request().username();
    UserAccount user = UserAccountBE.getUser(id);


    if (user == null) {
      return ok("TODO: user_account does not exit");
    }

    switch (user.getProfile()) {
      case UserAccount.ROOT_USER:
      case UserAccount.ADMIN_USER:
        return this.showAdminUserAccount(user);
      case UserAccount.SUPER_USER:
        return this.showSuperUserAccount(user);
      case UserAccount.USER:
        Form<UserAccount> formUserAccount = formFactory.form(UserAccount.class);
        formUserAccount = formUserAccount.fill(user);

        return ok(user_account.render(user,"Utilisateur", formUserAccount));
      default:
        return ok();
    }
  }

  public Result showAdminUserAccount ( UserAccount user ) {
    Form<UserAccount> formUserAccount = formFactory.form(UserAccount.class);
    formUserAccount = formUserAccount.fill(user);
    return ok(user_admin.render(user,"Administrateur Principal", formUserAccount ));
  }

  public Result showSuperUserAccount ( UserAccount user ) {

    Form<UserAccount> formUserAccount = formFactory.form(UserAccount.class);
    formUserAccount = formUserAccount.fill(user);

    return ok(user_super.render(user,"Administrateur", formUserAccount ));
  }

  public Result deleteUser(int id ) {

    this.actualUsername = request().username();
    UserAccount observer = UserAccountBE.getUserFromUsername(this.actualUsername);

    int accId = UserAccountBE.getUser(id).getClientAccountId();
    UserAccountBE.deleteUser(id);

    return UI_AccountController.getListFromAccount(accId);

    /*String url = "http://localhost:9000/account/userList/"+accId;

    CompletionStage<Result> resultPromise = ws.url(url).get().thenApply(response -> {
              return ok(response.getBody());
            }
    );

    return resultPromise;*/
  }

  public Result saveUser() {
    System.out.println("got req : "+request().username());
    return ok("TODO: user_account save/update method");
  }
  public Result createUser() { return ok("TODO: user_account create method");}

}
