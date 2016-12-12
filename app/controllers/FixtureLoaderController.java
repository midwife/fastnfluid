package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import play.libs.Json;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by MUSIQUE on 11/12/2016.
 */
public class FixtureLoaderController {

  public static JsonNode fromFile( String filename) {
    String chaine = "";
    //String fichier = "public/fixtures/AccountFixtures.json";

    //lecture du fichier texte
    try {
      InputStream ips = new FileInputStream(filename);
      InputStreamReader ipsr = new InputStreamReader(ips);
      BufferedReader br = new BufferedReader(ipsr);
      String ligne;
      while ((ligne = br.readLine()) != null) {
        chaine += ligne + "\n";
      }
      br.close();
    } catch (Exception e) {
      System.out.println(e.toString());
    }
    return Json.parse(chaine);
  }
}
