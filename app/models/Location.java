package models;

/**
 * Created by MUSIQUE on 28/11/2015.
 */
public class Location {
  private int id;

  public String address;
  public String addressComplement;
  public String zipCode;
  public String city;

  public String cellphone;
  public String phone;
  public String email;

  public double lat, lng;

  public Location () {this.id=0;}
  public Location ( Integer id ) {
      this.id = id;
  }

  public Location (int id, String address, String addressComplement, String zipCode, String city ) {
    this.id = id;
    this.address = address;
    this.addressComplement = addressComplement;
    this.zipCode = zipCode;
    this.city = city;
  }

  public int getId() {
    return this.id;
  }
  public void setId( int id ) { this.id = id; }
}