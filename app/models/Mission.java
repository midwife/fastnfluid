package models;

import java.util.Date;
import java.util.LinkedList;

/**
 * Created by MUSIQUE on 12/12/2015.
 */
public class Mission {

  private int accountId;
  private int id;
  private Date createdAt;
  private int sourceTypeId;
  private int sourceId;
  private int missionTypeId;
  private int missionTaskTypeId;
  private String missionName;
  private Date missionDate;
  private String locationcode;
  private String locationName;
  private String locationStreet;
  private String locationPostalCode;
  private String locationCountryCode;
  private String locationCountryName;
  private double locationLongitude;
  private double locationLatitude;
  private String receiptNumber;
  private String referenceNumber;
  private String productCode;
  private double quantity;
  private String quantityUnitCode;
  private double weight;
  private int euroPallet;

  public Mission () {
    this.createdAt = new Date();
  }

  public int getEuroPallet() {
    return euroPallet;
  }

  public void setEuroPallet(int euroPallet) {
    this.euroPallet = euroPallet;
  }

  public int getAccountId() {
    return accountId;
  }

  public void setAccountId(int accountId) {
    this.accountId = accountId;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public int getSourceTypeId() {
    return sourceTypeId;
  }

  public void setSourceTypeId(int sourceTypeId) {
    this.sourceTypeId = sourceTypeId;
  }

  public int getSourceId() {
    return sourceId;
  }

  public void setSourceId(int sourceId) {
    this.sourceId = sourceId;
  }

  public int getMissionTypeId() {
    return missionTypeId;
  }

  public void setMissionTypeId(int missionTypeId) {
    this.missionTypeId = missionTypeId;
  }

  public int getMissionTaskTypeId() {
    return missionTaskTypeId;
  }

  public void setMissionTaskTypeId(int missionTaskTypeId) {
    this.missionTaskTypeId = missionTaskTypeId;
  }

  public String getMissionName() {
    return missionName;
  }

  public void setMissionName(String missionName) {
    this.missionName = missionName;
  }

  public Date getMissionDate() {
    return missionDate;
  }

  public void setMissionDate(Date missionDate) {
    this.missionDate = missionDate;
  }

  public String getLocationcode() {
    return locationcode;
  }

  public void setLocationcode(String locationcode) {
    this.locationcode = locationcode;
  }

  public String getLocationName() {
    return locationName;
  }

  public void setLocationName(String locationName) {
    this.locationName = locationName;
  }

  public String getLocationStreet() {
    return locationStreet;
  }

  public void setLocationStreet(String locationStreet) {
    this.locationStreet = locationStreet;
  }

  public String getLocationPostalCode() {
    return locationPostalCode;
  }

  public void setLocationPostalCode(String locationPostalCode) {
    this.locationPostalCode = locationPostalCode;
  }

  public String getLocationCountryCode() {
    return locationCountryCode;
  }

  public void setLocationCountryCode(String locationCountryCode) {
    this.locationCountryCode = locationCountryCode;
  }

  public String getLocationCountryName() {
    return locationCountryName;
  }

  public void setLocationCountryName(String locationCountryName) {
    this.locationCountryName = locationCountryName;
  }

  public double getLocationLongitude() {
    return locationLongitude;
  }

  public void setLocationLongitude(double locationLongitude) {
    this.locationLongitude = locationLongitude;
  }

  public double getLocationLatitude() {
    return locationLatitude;
  }

  public void setLocationLatitude(double locationLatitude) {
    this.locationLatitude = locationLatitude;
  }

  public String getReceiptNumber() {
    return receiptNumber;
  }

  public void setReceiptNumber(String receiptNumber) {
    this.receiptNumber = receiptNumber;
  }

  public String getReferenceNumber() {
    return referenceNumber;
  }

  public void setReferenceNumber(String referenceNumber) {
    this.referenceNumber = referenceNumber;
  }

  public String getProductCode() {
    return productCode;
  }

  public void setProductCode(String productCode) {
    this.productCode = productCode;
  }

  public double getQuantity() {
    return quantity;
  }

  public void setQuantity(double quantity) {
    this.quantity = quantity;
  }

  public String getQuantityUnitCode() {
    return quantityUnitCode;
  }

  public void setQuantityUnitCode(String quantityUnitCode) {
    this.quantityUnitCode = quantityUnitCode;
  }

  public double getWeight() {
    return weight;
  }

  public void setWeight(double weight) {
    this.weight = weight;
  }

}
