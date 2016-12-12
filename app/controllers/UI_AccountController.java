package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import controllers.backend.AccountBE;
import controllers.backend.UserAccountBE;
import models.*;
import play.data.Form;
import play.data.FormFactory;
import play.libs.Json;
import play.libs.ws.*;

import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.html.*;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.concurrent.CompletionStage;

import static play.mvc.Http.Context.Implicit.request;

/**
 * Created by midwife123 on 09/05/2016.
 */

@Security.Authenticated(Secured.class)
public class UI_AccountController extends Controller {
  @Inject WSClient ws;
  @Inject private FormFactory formFactory;

  public Result CreateAccount() {
    Form<Account> formClientAccount = formFactory.form(Account.class);

    String username = request().username();

    UserAccount user = UserAccountBE.getUserFromUsername(username);
    String userType = user.getProfileStr();

    return ok(account.render("0","Editeur de Compte Sociétaire",formClientAccount,userType));
  }

  public Result SaveAccount() {
    Account account = formFactory.form(Account.class).bindFromRequest().get();
    Form<Account> caf = formFactory.form(Account.class);
    caf.fill(account);

    Form<UserAccount> userForm = formFactory.form(UserAccount.class);

    if (account.getId()==0) {
      AccountBE.CreateAccount(account);
      /**
       * Création du super user dans la foulée, même login, même mot de passe
       */
      UserAccount user = new UserAccount();
      user.setProfile(UserAccount.SUPER_USER);
      user.setUsername(account.getLogin());
      user.setPassword(account.getPassword());
      user.setClientAccount(account);
      userForm.fill(user);

      UserAccountBE.createUser(user);
    } else {
      AccountBE.UpdateAccount(account);
    }
    return ok(login.render("Identification", userForm));
  }

  public Result ShowAccount(int id ) {

    Account acc = AccountBE.getAccount(id);
    String username = request().username();

    UserAccount user = UserAccountBE.getUserFromUsername(username);
    String userType = user.getProfileStr();

    Form<Account> formClientAccount = formFactory.form(Account.class);
    formClientAccount = formClientAccount.fill(acc);
    return ok(account.render(username,"Compte",formClientAccount, userType));
  }

  public static Result getListFromAccount(int id) {
    String htmlToReturn = "";
    ArrayList<UserAccount> users = UserAccountBE.getUsersFromAccount(id);
    for (int i=0; i<users.size(); i++) {
      String AdminStr = "";
      String UserStr = "";
      String RootStr = "";

      switch (users.get(i).getProfile()) {
        case UserAccount.ROOT_USER:
          RootStr = "selected";
          break;
        case UserAccount.SUPER_USER:
          AdminStr = "selected";
          break;
        case UserAccount.USER:
          UserStr = "selected";
          break;
      }
      htmlToReturn += "<div class=\"row\">\n" +
              "                  <div class=\"input-field col s6\">\n" +
              "                    <input value=\""+users.get(i).getUsername()+"\" name=\"user_"+users.get(i).getId()+"_login\" id=\"user_"+users.get(i).getId()+"_login\" type=\"text\">\n" +
              "                    <label class=\"active\" for=\"user_"+users.get(i).getId()+"_login\">Identifiant</label>\n" +
              "                  </div>\n" +
              "                  <div class=\"input-field col s5\">\n" +
              "                    <select id=\"user_"+users.get(i).getId()+"_profile\" name=\"user_"+users.get(i).getId()+"_profile\">\n" +
              "                      <option value=\"0\" "+RootStr+" >Administrateur Principal</option>\n" +
              "                      <option value=\"2\" "+AdminStr+" >Administrateur</option>\n" +
              "                      <option value=\"10\" "+UserStr+" >Utilisateur</option>\n" +
              "                    </select>\n" +
              "                    <label for=\"user_"+users.get(i).getId()+"_profile\">Profile</label>\n" +
              "                  </div>\n" +
              "                  <div class=\"input-field col s1\">\n" +
              //"                    <i class=\"material-icons red-text text-darken-1\" style=\"cursor: pointer\" onclick=\"clearUser('"+users.get(i).getId()+"','"+users.get(i).getUsername()+"');\">clear</i>\n" +
              "                    <a href=\"#!\" class=\"btn waves-effect waves-light red white-text\" ic-delete-from=\"/user/" + users.get(i).getId() + "\" ic-confirm=\"Êtes vous sûr ?\" ic-target=\"#userList\"><i class=\"material-icons\" style=\"cursor: pointer\">clear</i></a>\n" +
              "                  </div>\n" +
              "                </div>\n"+
              "<script type=\"text/javascript\">$('select').material_select();</script>";
    }
    return ok(htmlToReturn).as("text/html");
  }

  public Result getHTMLUserListFromAccount(int id) {

    String htmlToReturn = "";
    ArrayList<UserAccount> users = UserAccountBE.getUsersFromAccount(id);
    for (int i=0; i<users.size(); i++) {
      String AdminStr = "";
      String UserStr = "";
      String RootStr = "";

      switch (users.get(i).getProfile()) {
        case UserAccount.ROOT_USER:
          RootStr = "selected";
          break;
        case UserAccount.SUPER_USER:
          AdminStr = "selected";
          break;
        case UserAccount.USER:
          UserStr = "selected";
          break;
      }
      htmlToReturn += "<div class=\"row\">\n" +
        "                  <div class=\"input-field col s6\">\n" +
        "                    <input value=\""+users.get(i).getUsername()+"\" name=\"user_"+users.get(i).getId()+"_login\" id=\"user_"+users.get(i).getId()+"_login\" type=\"text\">\n" +
        "                    <label class=\"active\" for=\"user_"+users.get(i).getId()+"_login\">Identifiant</label>\n" +
        "                  </div>\n" +
        "                  <div class=\"input-field col s5\">\n" +
        "                    <select id=\"user_"+users.get(i).getId()+"_profile\" name=\"user_"+users.get(i).getId()+"_profile\">\n" +
        "                      <option value=\"0\" "+RootStr+" >Administrateur Principal</option>\n" +
        "                      <option value=\"2\" "+AdminStr+" >Administrateur</option>\n" +
        "                      <option value=\"10\" "+UserStr+" >Utilisateur</option>\n" +
        "                    </select>\n" +
        "                    <label for=\"user_"+users.get(i).getId()+"_profile\">Profile</label>\n" +
        "                  </div>\n" +
        "                  <div class=\"input-field col s1\">\n" +
        //"                    <i class=\"material-icons red-text text-darken-1\" style=\"cursor: pointer\" onclick=\"clearUser('"+users.get(i).getId()+"','"+users.get(i).getUsername()+"');\">clear</i>\n" +
        "                    <a href=\"#!\" class=\"btn waves-effect waves-light red white-text\" ic-delete-from=\"/user/" + users.get(i).getId() + "\" ic-confirm=\"Êtes vous sûr ?\" ic-target=\"#userList\"><i class=\"material-icons\" style=\"cursor: pointer\">clear</i></a>\n" +
        "                  </div>\n" +
        "                </div>\n"+
        "<script type=\"text/javascript\">$('select').material_select();</script>";
    }
    return ok(htmlToReturn).as("text/html");
  }
}