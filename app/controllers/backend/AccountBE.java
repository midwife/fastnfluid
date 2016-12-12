package controllers.backend;

import com.fasterxml.jackson.databind.JsonNode;
import controllers.FixtureLoaderController;
import controllers.Secured;
import models.*;
import play.libs.Json;
import play.mvc.Security;

import java.io.*;
import java.util.ArrayList;

import static play.mvc.Results.ok;

/**
 * Created by MUSIQUE on 01/11/2016.
 */
@Security.Authenticated(Secured.class)
public class AccountBE {
  private static ArrayList<Account> accounts = new ArrayList<Account>();
  private static boolean alreadeySetUp = false;


  public static void loadFromFixture () {

    if (!AccountBE.alreadeySetUp) {

      String fichier = "public/fixtures/AccountFixtures.json";

     JsonNode accountsJson = FixtureLoaderController.fromFile(fichier);

      for (int i = 0; i < accountsJson.size(); i++) {
        Account ca = Json.fromJson(accountsJson.get(i), Account.class);
        AccountBE.accounts.add(ca);
      }

      AccountBE.alreadeySetUp = true;
    }
  }

  public static Account getAccount (int id ) {
    Account ca = null;
    for (int i = 0; i< AccountBE.accounts.size(); i++) {
      if (AccountBE.accounts.get(i).getId()==id) {
        ca = AccountBE.accounts.get(i);
        break;
      }
    }
    return ca;
  }

  public static void UpdateAccount ( Account account ) {
    for (int i = 0; i< AccountBE.accounts.size(); i++) {
      if (AccountBE.accounts.get(i).getId()==account.getId()) {
        AccountBE.accounts.set(i,account);
        break;
      }
    }
  }

  public static void CreateAccount ( Account account ) {
    int lastPos = AccountBE.accounts.size();
    account.setId(lastPos);
    AccountBE.accounts.add(account);
  }
}