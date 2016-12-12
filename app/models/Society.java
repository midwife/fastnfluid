package models;

/**
 * Created by MUSIQUE on 27/11/2016.
 */
public class Society {

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Location getLocation() {
    return location;
  }

  public void setLocation(Location location) {
    this.location = location;
  }

  public PersonOfContact getPoc() {
    return poc;
  }

  public void setPoc(PersonOfContact poc) {
    this.poc = poc;
  }

  public int getAccountId() {
    return accountId;
  }

  public void setAccountId(int accountId) {
    this.accountId = accountId;
  }

  private int id;
  private Location location;
  private PersonOfContact poc;
  private int accountId;

}
