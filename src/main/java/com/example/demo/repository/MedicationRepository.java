package com.example.demo.repository;

import com.example.demo.entity.MedicationEntity;
import org.springframework.data.repository.CrudRepository;

public interface MedicationRepository extends CrudRepository<MedicationEntity, Long> {
}
