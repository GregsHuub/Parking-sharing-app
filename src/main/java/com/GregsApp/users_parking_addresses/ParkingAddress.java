package com.GregsApp.users_parking_addresses;

import com.GregsApp.parkingAvalibility.ParkingAvailability;
import com.GregsApp.user.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

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

    private String fileName;
    private String fileType;
    @Lob
    private byte[] data;



    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @ManyToOne
    @JoinColumn(name = "park_avability_id")
    private ParkingAvailability parkingAvailability;




    @PrePersist
    public void prePersist() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm");
        // to zastosowac potem
        createdOn = LocalDateTime.now().withNano(0).withSecond(0);
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
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

    @Override
    public String toString() {
        return "ParkingAddress{" +
                "id=" + id +
                ", parkingName='" + parkingName + '\'' +
                ", parkingDescription='" + parkingDescription + '\'' +
                ", street='" + street + '\'' +
                ", streetNumber=" + streetNumber +
                ", maxWidth=" + maxWidth +
                ", maxHeight=" + maxHeight +
                ", feature_access_time='" + feature_access_time + '\'' +
                ", feature_custom='" + feature_custom + '\'' +
                ", createdOn=" + createdOn +
                ", reserved=" + reserved +
                ", accessInformation='" + accessInformation + '\'' +
                ", user=" + user +
                ", parkingAvailability=" + parkingAvailability +
                '}';
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ParkingAvailability getParkingAvailability() {
        return parkingAvailability;
    }

    public void setParkingAvailability(ParkingAvailability parkingAvailability) {
        this.parkingAvailability = parkingAvailability;
    }
}
