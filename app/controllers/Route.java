package controllers;

import models.Location;

/**
 * Created by MUSIQUE on 06/01/2016.
 */
public class Route {
  public int id;
  public String name;
  public Location origin;
  public Location destination;
  public Location[] waypoints;
}