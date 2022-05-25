package com.joegung.parkingapp.repository;

import com.joegung.parkingapp.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
    Optional<Vehicle> findByParkingSpaceId(int parkingSpaceId);
}
