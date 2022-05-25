package com.joegung.parkingapp.model;

import javax.persistence.*;


@Entity
@Table(name = "parking_spaces")
public class ParkingSpace {

    @Id
    @GeneratedValue
    private int id;

    @Enumerated(EnumType.STRING)
    private Size spaceSize;

    private boolean isOccupied;

    public ParkingSpace() {
    }

    public ParkingSpace(Size size, boolean isOccupied) {
        this.spaceSize = size;
        this.isOccupied = isOccupied;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Size getSpaceSize() {
        return spaceSize;
    }

    public void setSize(Size size) {
        this.spaceSize = size;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }
}
