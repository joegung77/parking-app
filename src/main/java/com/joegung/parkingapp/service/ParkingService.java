package com.joegung.parkingapp.service;

import com.joegung.parkingapp.exception.ParkingException;
import com.joegung.parkingapp.model.ParkingSpace;
import com.joegung.parkingapp.model.Vehicle;
import com.joegung.parkingapp.repository.ParkingSpaceRepository;
import com.joegung.parkingapp.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class ParkingService {

    @Autowired
    private ParkingSpaceRepository parkingSpaceRepository;

    @Autowired
    private VehicleRepository vehicleRepository;


    public String parkCar(Vehicle v) {
        int size = v.getVehicleSize().getSize();

        List<ParkingSpace> spaces = parkingSpaceRepository.findAll();
        ParkingSpace space = spaces.stream().filter(s -> !s.isOccupied() && (s.getSpaceSize().getSize() >= v.getVehicleSize().getSize()))
                .sorted(Comparator.comparing(ParkingSpace::getSpaceSize)).findFirst().orElseThrow(() -> new ParkingException("No available parking space for your vehicle."));

        v.setParkingSpace(space);
        vehicleRepository.save(v);

        space.setOccupied(true);
        parkingSpaceRepository.save(space);
        return v.getVehicleSize().toString().substring(0,1) + v.getVehicleSize().toString().toLowerCase()
                .substring(1) + " Vehicle sucessfully parked at parking spot " + space.getId() + ".";
    }

    public String unparkCar(int parkingSpaceId) {
        ParkingSpace space = parkingSpaceRepository.findById(parkingSpaceId).orElseThrow(() -> new ParkingException("Parking space does not exist."));
        space.setOccupied(false);
        parkingSpaceRepository.save(space);

        Vehicle vehicle = vehicleRepository.findByParkingSpaceId(parkingSpaceId).orElseThrow(() -> new ParkingException("No vehicle parked at spot " + space.getId() + "."));

        vehicleRepository.deleteById(vehicle.getId());

        return "Vehicle successfully unparked.";
    }
}
