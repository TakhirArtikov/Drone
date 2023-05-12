package com.example.demo.repository;

import com.example.demo.entity.DroneBatteryHistory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BatteryHistoryRepository extends CrudRepository<DroneBatteryHistory, Long> {
}
