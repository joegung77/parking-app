package com.joegung.parkingapp.controller;

import com.joegung.parkingapp.model.ParkingSpace;
import com.joegung.parkingapp.model.Vehicle;
import com.joegung.parkingapp.repository.ParkingSpaceRepository;
import com.joegung.parkingapp.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/parking")
public class ParkingSpaceController {

    @Autowired
    ParkingService parkingService;

    @Autowired
    ParkingSpaceRepository parkingSpaceRepository;

//    public ParkingSpaceController(ParkingService parkingService, ParkingSpaceRepository parkingSpaceRepository) {
//        this.parkingService = parkingService;
//        this.parkingSpaceRepository = parkingSpaceRepository;
//    }

    @GetMapping("/available")
    public List<ParkingSpace> getAvailableParkingSpaces() {
        List<ParkingSpace> spaces = parkingSpaceRepository.findAll();
        return spaces.stream().filter(s -> !s.isOccupied()).collect(Collectors.toList());
    }

    @PostMapping
    public String parkVehicle(@RequestBody Vehicle v) {
        return this.parkingService.parkCar(v);
    }

    @DeleteMapping("/{parking_space_id}")
    public String unparkVehicle(@PathVariable(name="parking_space_id") int parkingSpaceId) {
        return this.parkingService.unparkCar(parkingSpaceId);
    }
}
