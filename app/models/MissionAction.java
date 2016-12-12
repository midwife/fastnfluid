package models;

import play.api.mvc.MultipartFormData;
import play.data.format.Formats;

import java.util.Date;

/**
 * Created by MUSIQUE on 12/12/2015.
 */
public class MissionAction {
  public static final int DELIVERY = 1;
  public static final int COLLECT = 2;

  public int id;
  public int sort;

  @Formats.DateTime(pattern="HH:mm")
  public Date deadline;
  public int unity;

  public MissionAction ( int id, int sort, int unity, Date deadline ) {
    this.id = id;
    this.sort = sort;
    this.unity = unity;
    this.deadline = deadline;
  }
}
