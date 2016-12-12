package controllers.backend;

import com.fasterxml.jackson.databind.JsonNode;
import controllers.FixtureLoaderController;
import controllers.Secured;
import models.Society;
import play.libs.Json;
import play.mvc.Security;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by MUSIQUE on 11/12/2016.
 */
@Security.Authenticated(Secured.class)
public class SocietyBE {
  private static ArrayList<Society> societies = new ArrayList<>();
  private static boolean alreadeySetUp = false;

  public static void loadFromFixtures() {
    if (!SocietyBE.alreadeySetUp) {

      JsonNode societiesJson = FixtureLoaderController.fromFile("public/fixtures/SocietyFixtures.json");

      for (int i = 0; i < societiesJson.size(); i++) {
        Society society = Json.fromJson(societiesJson.get(i), Society.class);
        SocietyBE.societies.add(society);
      }

      SocietyBE.alreadeySetUp = true;
    }
  }

  public static ArrayList<Society> getSocieties() {
    return SocietyBE.societies;
  }

  public static void setSocieties(ArrayList<Society> societies) {
    SocietyBE.societies = societies;
  }
}
