package com.example.demo.repository;

import com.example.demo.entity.DroneEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


@Repository
public interface DroneRepository extends JpaRepository<DroneEntity, String> {

    DroneEntity findBySerialNumber(String serialNumber);

}
