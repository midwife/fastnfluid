package models;

import java.util.Date;

/**
 * Created by MUSIQUE on 01/11/2016.
 */
public class Account {
  private int id;

  private String societyName;
  private String login;
  private String password;
  private String email;
  private Location location;
  private PersonOfContact poc;
  private String siret;
  private Position position;

  private boolean isActive;
  private Date activationDate;
  private Date desactivationDate;

  private Date created_at;
  private Date updated_at;

  private BillingInformation billingInformation;

  public Account() {
    this.id = 0;
    this.isActive = false;
    this.created_at = new Date();
    this.updated_at = new Date();
  }

  public String getSocietyName() {
    return societyName;
  }

  public void setSocietyName(String societyName) {
    this.societyName = societyName;
    this.updated_at = new Date();
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
    this.updated_at = new Date();
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
    this.updated_at = new Date();
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
    this.updated_at = new Date();
  }

  public PersonOfContact getPoc() {
    return poc;
  }

  public void setPoc(PersonOfContact poc) {
    this.poc = poc;
    this.updated_at = new Date();
  }

  public String getSiret() {
    return siret;
  }

  public void setSiret(String siret) {
    this.siret = siret;
    this.updated_at = new Date();
  }

  public boolean isActive() {
    return isActive;
  }

  public void setActive(boolean active) {
    isActive = active;
    this.updated_at = new Date();
  }

  public Date getActivationDate() {
    return activationDate;
  }

  public void setActivationDate(Date activationDate) {
    this.activationDate = activationDate;
    this.updated_at = new Date();
  }

  public Date getDesactivationDate() {
    return desactivationDate;
  }

  public void setDesactivationDate(Date desactivationDate) {
    this.desactivationDate = desactivationDate;
    this.updated_at = new Date();
  }

  public BillingInformation getBillingInformation() {
    return billingInformation;
  }

  public void setBillingInformation(BillingInformation billingInformation) {
    this.billingInformation = billingInformation;
    this.updated_at = new Date();
  }

  public Position getPosition() {
    return position;
  }

  public void setPosition(Position position) {
    this.position = position;
    this.updated_at = new Date();
  }

  public Location getLocation() {
    return location;
  }

  public void setLocation(Location location) {
    this.location = location;
    this.updated_at = new Date();
  }

  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
}
