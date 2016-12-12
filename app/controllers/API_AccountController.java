package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import controllers.backend.AccountBE;
import models.*;
import play.libs.Json;
import play.mvc.*;

/**
 * Created by midwife123 on 09/05/2016.
 */
//@Security.Authenticated(Secured.class)
public class API_AccountController extends Controller {
  public Result getAccountFromID ( int id ) {
    Account account = AccountBE.getAccount(id);
    JsonNode accountJson = Json.toJson(account);
    return ok(accountJson);
  }
}
