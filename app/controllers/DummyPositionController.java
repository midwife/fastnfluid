package controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import models.*;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;

import java.io.IOException;

import static play.mvc.Results.ok;

/**
 * Created by MUSIQUE on 02/12/2015.
 */
@Security.Authenticated(Secured.class)
public class DummyPositionController extends Controller {

  private DummyPosition dummyPosition;
  private boolean alreadyCreated=false;

  public Result getCurrentPositionJSON ( int id ) {
    if (alreadyCreated==false) {
      dummyPosition = new DummyPosition();
      alreadyCreated = true;
    }
    Position currentPosition = dummyPosition.getCurrentPosition();
    ObjectNode result = Json.newObject();
    result.put("name", currentPosition.getName()+" "+id);
    result.put("lat", currentPosition.getLatitude());
    result.put("lng", currentPosition.getLongitude());

    return ok(result);
  }

  public Result getPositionFromGeocode () throws IOException {
    Location loc = new Location(255,"27 Rue Chanzy","","21000","Dijon");
    return ok("test");
  }
}