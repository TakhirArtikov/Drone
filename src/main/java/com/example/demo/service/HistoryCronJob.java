package com.example.demo.service;

import com.example.demo.entity.DroneBatteryHistory;
import com.example.demo.entity.DroneEntity;
import com.example.demo.repository.BatteryHistoryRepository;
import com.example.demo.repository.DroneRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@Component
@Slf4j
public class HistoryCronJob {

    private final DroneRepository droneRepository;
    private final BatteryHistoryRepository batteryHistoryRepository;

    @Scheduled(cron = "0 0 9 * * *",zone = "Asia/Tashkent")
    public void cronJob() {
        log.info("Cron job started at {}", LocalDateTime.now());
        List<DroneEntity> drones= (List<DroneEntity>) droneRepository.findAll();
        List<DroneBatteryHistory> histories = new ArrayList<>();

        for (DroneEntity dron: drones) {
            DroneBatteryHistory history = new DroneBatteryHistory();
            history.setSerialNumber(dron.getSerialNumber());
            history.setBatteryLevel(dron.getBatteryCapacity());
            history.setDateTime(LocalDateTime.now());
            histories.add(history);
        }
        batteryHistoryRepository.saveAll(histories);

    }
}
