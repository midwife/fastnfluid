package controllers.backend;

import com.fasterxml.jackson.databind.JsonNode;
import controllers.FixtureLoaderController;
import controllers.Secured;
import models.*;
import play.libs.Json;
import play.mvc.*;
import scala.Console;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import static play.mvc.Results.ok;

/**
 * Created by MUSIQUE on 02/11/2016.
 */

@Security.Authenticated(Secured.class)
public class UserAccountBE {
  private static ArrayList<UserAccount> users = new ArrayList<UserAccount>();
  private static ArrayList<Society> societies = new ArrayList<Society>();

  private static boolean alreadySetup = false;

  public static void loadFromFixtures() {
    if (!UserAccountBE.alreadySetup) {

      String chaine = "";
      String fichier = "public/fixtures/UserAccountFixtures.json";

      Society society = new Society();
      society.setId(0);
      Location locus = new Location(15, "address1", "address2", "21000", "Dijon");
      society.setLocation(locus);
      society.setPoc(new PersonOfContact(255, "Zitouna", locus));
      society.setAccountId(0);
      societies.add(society);

      Society society2 = new Society();
      society2.setId(0);
      Location locus2 = new Location(15, "address1", "address2", "21000", "Dijon");
      society2.setLocation(locus2);
      society2.setPoc(new PersonOfContact(255, "Zitouna 2", locus));
      society2.setAccountId(0);
      societies.add(society2);

      SocietyBE.setSocieties(societies);

      JsonNode accountsJson = FixtureLoaderController.fromFile(fichier);

      for (int i = 0; i < accountsJson.size(); i++) {
        UserAccount user = Json.fromJson(accountsJson.get(i), UserAccount.class);
        UserAccountBE.users.add(user);
      }
      UserAccountBE.alreadySetup = true;
    }
    //Console.println("users size : "+UserAccountBE.users.size());
  }

  public static UserAccount getUser (int id) {
    if (UserAccountBE.users.size()!=0) {
      for ( int i = 0; i < UserAccountBE.users.size(); i++ ) {
        if (UserAccountBE.users.get(i).getId()==id) {
          return UserAccountBE.users.get(i);
        }
      }
    }
    return null;
  }

  public static ArrayList getUsersFromAccount (Account account) {
    ArrayList<UserAccount> listToReturn = new ArrayList<UserAccount>();
    if (UserAccountBE.users.size()!=0) {
      for ( int i = 0; i < UserAccountBE.users.size(); i++ ) {
        if (UserAccountBE.users.get(i).getClientAccount().equals(account)) {
          listToReturn.add(UserAccountBE.users.get(i));
        }
      }
    }
    return listToReturn;
  }

  public static ArrayList getUsersFromAccount ( int accountId ) {
    return getUsersFromAccount(AccountBE.getAccount(accountId));
  }

  public Result updateUser ( int id ) {
    return ok("TODO: user update method");
  }

  public static boolean Exists(UserAccount user ) {
    return UserAccountBE.Exists(user.getUsername(),user.getPassword());
  }

  public static boolean Exists(String login, String password ) {
    if (UserAccountBE.users.size()!=0) {
      for ( int i = 0; i < UserAccountBE.users.size(); i++ ) {
        if ( (UserAccountBE.users.get(i).getUsername().equals(login)) && (UserAccountBE.users.get(i).getPassword().equals(password)) )
          return true;
      }
    }
    return false;
  }

  public static void createUser(UserAccount user ) {
    int i = UserAccountBE.users.size();
    user.setId(i+1);
    UserAccountBE.users.add(user);
  }

  public static void updateUser ( UserAccount user ) {
    for (int i=0; i< users.size(); i++) {
      if (users.get(i).getId()==user.getId()) {
        users.set(i,user);
        break;
      }
    }
  }

  public static void deleteUser ( int id ) {
    for (int i=0; i < users.size(); i ++) {
      if (users.get(i).getId()==id) {
        users.remove(i);
        break;
      }
    }
  }

  public static void deleteUser ( UserAccount user ) {
    deleteUser(user.getId());
  }

  public static UserAccount getUserFromUsername (String username) {
    for (int i=0; i< UserAccountBE.users.size(); i++) {
      if (users.get(i).getUsername().equals(username)) {
        return users.get(i);
      }
    }
    return null;
  }

  public static Result SetFixture () {

    Account ca1 = AccountBE.getAccount(0);
    Account ca2 = AccountBE.getAccount(1);

    UserAccount user1 = new UserAccount(0);
    user1.setUsername("user1");
    user1.setPassword("pwd1");
    user1.setProfile(UserAccount.SUPER_USER);
    user1.setClientAccount(ca1);

    UserAccount user2 = new UserAccount(1);
    user2.setUsername("user2");
    user2.setPassword("pwd2");
    user2.setProfile(UserAccount.USER);
    user2.setClientAccount(ca1);

    UserAccount user3 = new UserAccount(3);
    user3.setUsername("user3");
    user3.setPassword("pwd3");
    user3.setProfile(UserAccount.SUPER_USER);
    user3.setClientAccount(ca2);

    UserAccount user4 = new UserAccount(4);
    user4.setUsername("user4");
    user4.setPassword("pwd4");
    user4.setProfile(UserAccount.USER);
    user4.setClientAccount(ca2);

    UserAccount user5 = new UserAccount(5);
    user5.setUsername("user5");
    user5.setPassword("pwd5");
    user5.setProfile(UserAccount.USER);
    user5.setClientAccount(ca2);

    UserAccountBE.users.add(user1);
    UserAccountBE.users.add(user2);
    UserAccountBE.users.add(user3);
    UserAccountBE.users.add(user4);
    UserAccountBE.users.add(user5);

    JsonNode userListJson = Json.toJson(UserAccountBE.users);
    return ok(userListJson);
  }
}
