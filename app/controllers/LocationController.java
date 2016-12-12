package controllers;

import play.mvc.Controller;
import models.*;

import java.util.LinkedList;

/**
 * Created by MUSIQUE on 29/11/2015.
 */
public class LocationController extends Controller {
  private LinkedList<Location> locations;

  public LocationController() {
    locations = new LinkedList<>();
    locations.add( new Location(1,"1T Rue des Iris","","25390","ORCHAMPS VENNES"));
    locations.add( new Location(2,"27 Rue Chanzy","","21000","DIJON"));
    locations.add( new Location(3,"7 Rue de la Chaussée","","25500","MORTEAU"));
    locations.add( new Location(4,"2 Rue des Armaillis","","25140","CHARQUEMONT"));
  }

  public LinkedList<Location> getLocations() {
    return this.locations;
  }

  public Location getLocation ( int id ) {
    for(int count=0; count<this.locations.size(); count++) {
      if (locations.get(count).getId()== id) { return locations.get(count); }
    }
    return null;
  }
}
