package models;

/**
 * Created by MUSIQUE on 02/12/2015.
 */
public class DummyPosition {

  private Position currentPosition;

  private Position initialPosition;
  private Position finalPosition;
  private int nbIterations=100;

  private int count;
  private double dLatitude;
  private double dLongitude;

  public DummyPosition() {
    this.initialPosition = new Position("StartPos", 47.3350744f, 5.0444479f);
    this.finalPosition = new Position("DestinationPos", 47.2153338f, 6.8118516f);

    this.dLatitude  = (this.finalPosition.getLatitude() -this.initialPosition.getLatitude()) /this.nbIterations;
    this.dLongitude = (this.finalPosition.getLongitude()-this.initialPosition.getLongitude())/this.nbIterations;

    this.currentPosition = new Position("currentPosition",this.initialPosition.getLatitude(),this.initialPosition.getLongitude());

    this.count = 0;
  }

  public Position getCurrentPosition () {
    double currentLatitude;
    double currentLongitude;

    currentLatitude =  this.initialPosition.getLatitude() +this.dLatitude*this.count;
    currentLongitude = this.initialPosition.getLongitude()+this.dLongitude*this.count;

    this.count=(this.count+1)%this.nbIterations;

    this.currentPosition.setLatitude(currentLatitude);
    this.currentPosition.setLongitude(currentLongitude);

    if (this.currentPosition.getDistance(this.finalPosition)<5000) {
      this.currentPosition.setName("currentPosition Near Objective !");
    } else {
      this.currentPosition.setName("currentPosition");
    }
    return this.currentPosition;
  }
}
