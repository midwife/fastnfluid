package models;

/**
 * Created by MUSIQUE on 02/12/2015.
 */
public class Position {
  private double latitude;
  private double longitude;
  private String name;

  public Position() {}

  public Position ( String name, double latitude, double longitude ) {
    this.latitude = latitude;
    this.longitude = longitude;
    this.name = name;
  }

  public String getName() {
    return this.name;
  }
  public double getLatitude() {
    return this.latitude;
  }
  public double getLongitude() {
    return this.longitude;
  }

  public void setLatitude( double latitude ) {
    this.latitude = latitude;
  }
  public void setLongitude( double longitude ) {
    this.longitude = longitude;
  }
  public void setName ( String name ) {
    this.name = name;
  }

  private double rad ( double x) {
    return ((x * Math.PI) / 180);
  }

  /**
   * Haversine Formula to calculate the distance between two points ( lat/lng )
   * @param comparedPosition
   * @return distance in meters betwwen the currentPosition compared to the comparedPosition
   */
  public int getDistance ( Position comparedPosition ) {
    double R = 6378137;
    double dlat = this.rad(comparedPosition.getLatitude()-this.getLatitude());
    double dlng = this.rad(comparedPosition.getLongitude()-this.getLongitude());

    double a = Math.sin(dlat/2)*Math.sin(dlat/2) + Math.cos(rad(this.getLatitude()))*Math.cos(rad(comparedPosition.getLatitude()))*Math.sin(dlng/2)*Math.sin(dlng/2);

    double c = 2*Math.atan2( Math.sqrt(a), Math.sqrt(1-a));

    return (int) (R*c);
  }
}
