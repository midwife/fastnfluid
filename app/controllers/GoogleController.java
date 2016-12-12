package controllers;

import com.fasterxml.jackson.databind.JsonNode;

import models.Position;
import play.libs.ws.*;
import play.libs.F.Promise;

import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;

import javax.inject.Inject;

/**
 * Created by MUSIQUE on 02/12/2015.
 */
@Security.Authenticated(Secured.class)
public class GoogleController extends Controller {
  //@Inject WSClient ws;

  private static final String key = "AIzaSyAsAzOBFyF1-580nuCwp65ZVhRvLE-U_mU";
  private static final String GEOCODE_ENDPOINT = "https://maps.googleapis.com/maps/api/geocode";

  /*public Promise<Result> from( String address) {

    /*address = address.replace(" ","+");
    String GoogleArgs = GoogleController.GEOCODE_ENDPOINT+"/json?address="+address+"&key"+GoogleController.key;

    Promise<Result> result = WS.url(GoogleArgs).get().map(response -> {
      JsonNode data = response.asJson();
      String STATUS = data.findPath("status").asText();
      JsonNode results;
      if (STATUS.equals("OK")) {
        results = data.findPath("location");
        String formatted_address = data.findPath("formatted_address").asText();

        double lat = results.get("lat").asDouble();
        double lng = results.get("lng").asDouble();
        Position position = new Position(formatted_address,lat,lng);
        return ok(position.getName()+" : {lat:"+position.getLatitude()+", lng: "+position.getLongitude()+"}");
      }
      return ok("not found from geocode");
    });

    return result;
  }*/
}