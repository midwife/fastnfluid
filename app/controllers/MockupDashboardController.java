package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import models.Location;

import play.libs.*;
import play.mvc.*;
import views.html.mockup_dashboard;

import java.io.*;

/**
 * Created by MUSIQUE on 22/12/2015.
 */
@Security.Authenticated(Secured.class)
public class MockupDashboardController extends Controller {
  public Route[] routes;

  public Result getGeocodedData() {
    String jsonData = "";
    try {
      String filename = "public/fixtures/missions-fixtures.json";
      BufferedReader br = new BufferedReader( new FileReader(filename));
      StringBuilder sb = new StringBuilder();
      String line = br.readLine();
      while (line!= null) {
        sb.append(line);
        line=br.readLine();
      }
      jsonData = sb.toString();
    } catch (Exception e) {
      e.printStackTrace();
      jsonData = "error on reading JSON data fixture";
    }
    JsonNode result = Json.parse(jsonData);
    return ok(result);
  }

  public Result mockup() {
    String username = request().username();
    return ok(mockup_dashboard.render(username));
  }
}
