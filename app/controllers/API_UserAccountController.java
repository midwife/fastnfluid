package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import controllers.backend.UserAccountBE;
import models.Account;
import models.UserAccount;
import play.libs.Json;
import play.mvc.Result;

import java.util.ArrayList;

import static play.mvc.Results.ok;

/**
 * Created by MUSIQUE on 02/11/2016.
 */
public class API_UserAccountController {
  public Result getUserFromID(int id) {
    UserAccount user = UserAccountBE.getUser(id);
    JsonNode userJson = Json.toJson(user);
    return ok(userJson);
    //return ok("TODO: API_UserAccountController.getUserFromID implementation");
  }

  public Result getUserList() {
    return UserAccountBE.SetFixture();
  }

  public Result getUsersFromAccount (int accoundId) {
    return ok(Json.toJson(UserAccountBE.getUsersFromAccount(accoundId)));
  }

  public Result getUsersFromAccount( Account account ) {
    return ok(Json.toJson(this.getUsersFromAccount(account.getId())));
  }
}
