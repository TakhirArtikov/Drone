package com.example.demo.repository;

import com.example.demo.entity.DroneEntity;
import com.example.demo.entity.MedicationEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DroneRepository extends CrudRepository<DroneEntity, String> {

    DroneEntity findBySerialNumber(String serialNumber);


}
