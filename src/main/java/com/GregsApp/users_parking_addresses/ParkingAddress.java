package com.GregsApp.users_parking_addresses;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "users_parking_addresses")
public class ParkingAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String parkingName;
    private String parkingDescription;
    @NotNull
    private String street;
    @NotNull
    private Integer streetNumber;
    private Double maxWidth;
    private Double maxHeight;
    private String feature_access_time; // for example 24/7 access
    private String feature_custom; // custom like Light at night, security etc.
    private LocalDateTime createdOn;
    private boolean reserved; // default false;
    private String accessInformation;


    // information about how to get there, where to buy a ticket, speak with reception etc.
    // example
//    1) Take a ticket at the entrance.
//
//2) Park at the location of your choice.
//
//3) Introduce yourself to the reception with your reservation received by email.
//    1) Take a ticket at the entrance of the car park
//
//2) You can park on any spot parking spot
//
//3) Upon leaving, validate your ticket at your desk by showing your mobypark booking confirmation.

    @PrePersist
    public void prePersist(){
        createdOn = LocalDateTime.now().withNano(0);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getParkingName() {
        return parkingName;
    }

    public void setParkingName(String parkingName) {
        this.parkingName = parkingName;
    }

    public String getParkingDescription() {
        return parkingDescription;
    }

    public void setParkingDescription(String parkingDescription) {
        this.parkingDescription = parkingDescription;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(Integer streetNumber) {
        this.streetNumber = streetNumber;
    }

    public Double getMaxWidth() {
        return maxWidth;
    }

    public void setMaxWidth(Double maxWidth) {
        this.maxWidth = maxWidth;
    }

    public Double getMaxHeight() {
        return maxHeight;
    }

    public void setMaxHeight(Double maxHeight) {
        this.maxHeight = maxHeight;
    }

    public String getFeature_access_time() {
        return feature_access_time;
    }

    public void setFeature_access_time(String feature_access_time) {
        this.feature_access_time = feature_access_time;
    }

    public String getFeature_custom() {
        return feature_custom;
    }

    public void setFeature_custom(String feature_custom) {
        this.feature_custom = feature_custom;
    }

    public String getAccessInformation() {
        return accessInformation;
    }

    public void setAccessInformation(String accessInformation) {
        this.accessInformation = accessInformation;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }
}
