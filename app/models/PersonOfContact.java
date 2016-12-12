package models;

/**
 * Created by MUSIQUE on 12/12/2015.
 */
public class PersonOfContact {
  private int id;
  private String name;
  private Location location;

  public PersonOfContact() {this.id=0;}

  public PersonOfContact( int id, String name, Location location ) {
    this.id = id;
    this.name = name;
    this.location = location;
  }

  public void addPhone( String phoneNumber ) {this.location.phone = phoneNumber;}

  public void addCellphone ( String cellphoneNumber ) {this.location.cellphone = cellphoneNumber;}

  public int getId() { return this.id; }
  public void setId( int id ) { this.id = id; }

  public String getName() { return this.name; }
  public void setName( String name ) { this.name = name; }

  public Location getLocation() { return this.location; }
  public void setLocation( Location location ) { this.location = location; }
}