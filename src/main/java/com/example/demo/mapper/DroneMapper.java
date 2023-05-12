package com.example.demo.mapper;

import com.example.demo.dto.DroneDto;
import com.example.demo.entity.DroneEntity;
import org.springframework.stereotype.Component;

@Component
public class DroneMapper {

    public DroneEntity toEntity(DroneDto dto) {
        DroneEntity entity=new DroneEntity();
        entity.setBatteryCapacity(dto.getBatteryCapacity());
        entity.setModel(dto.getModel());
        entity.setState(dto.getState());
        entity.setSerialNumber(dto.getSerialNumber());
        entity.setWeightLimit(dto.getWeightLimit());
        entity.setMedications(dto.getMedications());
        return entity;
    }

    public DroneDto toDto(DroneEntity entity) {
        DroneDto dto=new DroneDto();
        dto.setBatteryCapacity(entity.getBatteryCapacity());
        dto.setModel(entity.getModel());
        dto.setState(entity.getState());
        dto.setSerialNumber(entity.getSerialNumber());
        dto.setWeightLimit(entity.getWeightLimit());
        dto.setMedications(entity.getMedications());
        return dto;
    }

}
