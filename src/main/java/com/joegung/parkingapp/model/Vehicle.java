package com.joegung.parkingapp.model;

import javax.persistence.*;

@Entity
@Table(name = "vehicles")
public class Vehicle {

    @Id
    @GeneratedValue
    private int id;

    @Enumerated(EnumType.STRING)
    private Size vehicleSize;

    @OneToOne
    @JoinColumn(name = "parking_space_id", referencedColumnName = "id")
    private ParkingSpace parkingSpace;

    public Vehicle() {
    }

    public Vehicle(int id, Size size, ParkingSpace parkingSpace) {
        this.id = id;
        this.vehicleSize = size;
        this.parkingSpace = parkingSpace;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Size getVehicleSize() {
        return vehicleSize;
    }

    public void setSize(Size size) {
        this.vehicleSize = size;
    }

    public ParkingSpace getParkingSpace() {
        return parkingSpace;
    }

    public void setParkingSpace(ParkingSpace parkingSpace) {
        this.parkingSpace = parkingSpace;
    }
}
