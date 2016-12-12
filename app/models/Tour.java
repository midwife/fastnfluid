package models;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by MUSIQUE on 07/02/2016.
 */
public class Tour {
  private String tourName;
  private ArrayList<Mission> missions;

  public Tour () {
    this.missions = new ArrayList<>();
  }

  public void addMission ( Mission mission ) {
    this.missions.add(mission);
  }

  public ArrayList<Mission> getAllMissions () {
    return this.missions;
  }

  public Mission getMission ( int id ) {
    return this.missions.get(id);
  }

  public String getTourName() {
    return tourName;
  }

  public void setTourName(String tourName) {
    this.tourName = tourName;
  }
}
