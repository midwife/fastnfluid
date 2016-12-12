package controllers;

import models.*;

import play.data.Form;
import play.libs.Json;
import play.mvc.*;
import views.html.*;

import java.util.Date;
import java.util.LinkedList;

/**
 * Created by MUSIQUE on 12/12/2015.
 */
@Security.Authenticated(Secured.class)
public class MissionController extends Controller {

  public Result index() {
    String username = request().username();
    Tour tour = new Tour();
    tour.setTourName("Tour name fixture");
    Mission missionfixure = new Mission();

    missionfixure.setAccountId(0);
    missionfixure.setId(0);
    missionfixure.setSourceId(1);
    missionfixure.setSourceTypeId(1);
    missionfixure.setMissionTypeId(2);
    missionfixure.setMissionTaskTypeId(2);
    missionfixure.setMissionDate( new Date());
    missionfixure.setMissionName("Mission 0 Name fixture");
    missionfixure.setLocationcode("test locationCode");
    missionfixure.setLocationName("Cabinet de SageFemme");
    missionfixure.setLocationStreet("7, Rue de la Chaussée");
    missionfixure.setLocationPostalCode("25500");
    missionfixure.setLocationCountryCode("fr");
    missionfixure.setLocationCountryName("France");
    missionfixure.setLocationLatitude(47.0561306);
    missionfixure.setLocationLongitude(6.6004014);
    missionfixure.setReceiptNumber("12");
    missionfixure.setReferenceNumber("12");
    missionfixure.setProductCode("Palette1");
    missionfixure.setQuantity(2);
    missionfixure.setQuantityUnitCode("kg");
    missionfixure.setWeight(980.5);
    missionfixure.setEuroPallet(3);

    tour.addMission(missionfixure);
    Form<Tour> tourForm = Form.form(Tour.class).fill(tour);

    return ok(mission.render(username, "Transport Management System / RaggingBull - Midwife", tourForm));
  }

  public Result showMission( int id ) {
    String username = request().username();
    Mission mission = new Mission();

    Form<Mission> missionForm = Form.form(Mission.class).fill(mission);

    return ok(mission_edit.render(username, "Transport Management System / RaggingBull - Midwife", missionForm ));
  }

  public Result saveMission() {
    Mission mission = Form.form(Mission.class).bindFromRequest().get();

    int id = mission.getId();

    return ok("Test ! \n"+id);
  }
}