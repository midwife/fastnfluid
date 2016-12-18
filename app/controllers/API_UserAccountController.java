package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import controllers.backend.UserAccountBE;
import models.Account;
import models.UserAccount;
import org.h2.engine.User;
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

  public Result getUsersFromAccount ( int userId) {
    return ok(Json.toJson(UserAccountBE.getUsersFromAccount(userId)));
  }

  public Result getUsersFromAccount(UserAccount user) {
    return ok(Json.toJson(this.getUsersFromAccount(user.getId())));
  }
}
