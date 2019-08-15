package com.GregsApp.user;

import com.GregsApp.address.HomeAddress;
import com.GregsApp.reservation.Reservation;
import com.GregsApp.users_parking_addresses.ParkingAddress;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "You have to provide your name")
    private String firstName;
    @NotBlank(message = "You have to privide your lastname")
    private String lastName;
    private String contactNumber;
    @Email
    @NotBlank(message = "You have to provide your email")
    @Column(unique = true)
    private String email;
    private String password;
    @Column(name = "created_time")
    private LocalDateTime createdOn;
    @Column(name = "updated_time")
    private LocalDateTime updatedOn;

    @PrePersist
    public void prePersist() {
        createdOn = LocalDateTime.now().withNano(0);
    }

    @PreUpdate
    public void preUpdate() {
        updatedOn = LocalDateTime.now();
    }

    @OneToOne
    private HomeAddress homeAddress;
    @OneToMany(mappedBy = "user")
    Set<ParkingAddress> parkingAddress;
    @OneToMany(mappedBy = "user")
    private Reservation reservation;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
    }

    public HomeAddress getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(HomeAddress homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Set<ParkingAddress> getParkingAddress() {
        return parkingAddress;
    }

    public void setParkingAddress(Set<ParkingAddress> parkingAddress) {
        this.parkingAddress = parkingAddress;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", createdOn=" + createdOn +
                ", updatedOn=" + updatedOn +
                ", homeAddress=" + homeAddress +
                '}';
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
}
