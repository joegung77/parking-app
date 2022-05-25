package com.joegung.parkingapp.service;

import com.joegung.parkingapp.model.ParkingSpace;
import com.joegung.parkingapp.model.Size;
import com.joegung.parkingapp.repository.ParkingSpaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ParkingInitializer implements CommandLineRunner {

    @Autowired
    private final ParkingSpaceRepository parkingSpaceRepository;

    public ParkingInitializer(ParkingSpaceRepository parkingSpaceRepository) {
        this.parkingSpaceRepository = parkingSpaceRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        List<ParkingSpace> spaces = Arrays.asList(
                new ParkingSpace(Size.SMALL, false),
                new ParkingSpace(Size.SMALL, false),
                new ParkingSpace(Size.MEDIUM, false),
                new ParkingSpace(Size.MEDIUM, false),
                new ParkingSpace(Size.LARGE, false),
                new ParkingSpace(Size.LARGE, false),
                new ParkingSpace(Size.LARGE, false)

        );

        parkingSpaceRepository.saveAll(spaces);

    }

}
