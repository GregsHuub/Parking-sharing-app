package com.GregsApp.parkingAvalibility;

import com.GregsApp.users_parking_addresses.ParkingAddress;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "parkingAvailability")
public class ParkingAvailability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean availabilityNow;
    private Date updateStatus;
    @Temporal(TemporalType.TIMESTAMP)
    private Date avabilityParkingTimeSetByOwner;
    @OneToMany(mappedBy = "parkingAvailability")
    private Set<ParkingAddress> parkingAddress;

    @Override
    public String toString() {
        return "ParkingAvailability{" +
                "id=" + id +
                ", availabilityNow=" + availabilityNow +
                ", updateStatus=" + updateStatus +
                ", avabilityParkingTimeSetByOwner=" + avabilityParkingTimeSetByOwner +
                '}';
    }
}
