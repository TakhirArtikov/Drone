package com.example.demo.service;

import com.example.demo.dto.DroneDto;
import com.example.demo.dto.LoadDto;
import com.example.demo.dto.MedicationDto;

import java.util.List;

public interface DroneService {
    void register(DroneDto dto);
    void load(LoadDto dto);
    List<DroneDto> checkAvailableDrone();
    MedicationDto checkMedicationItems(String serialNumber);
    Double getBatteryLevel(String serialNumber);
}
