package models;

import java.util.Date;

/**
 * Created by MUSIQUE on 01/11/2016.
 */
public class BillingInformation {
  private int id;
  private Date created_at;
  private Date updated_at;

  public BillingInformation() {
    this.id = 65000;
    this.created_at = new Date();
    this.updated_at = new Date();
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
    this.updated_at = new Date();
  }

  public Date getCreated_at() {
    return created_at;
  }

  public Date getUpdated_at() {
    return updated_at;
  }
}
