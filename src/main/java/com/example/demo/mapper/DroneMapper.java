package com.example.demo.mapper;

import com.example.demo.dto.DroneDto;
import com.example.demo.entity.DroneEntity;

public class DroneMapper {

    public DroneEntity toEntity(DroneDto dto) {
        DroneEntity entity=new DroneEntity();
        entity.setBattery_capacity(dto.getBattery_capacity());
        entity.setModel(dto.getModel());
        entity.setState(dto.getState());
        entity.setSerial_number(dto.getSerial_number());
        entity.setWeight_limit(dto.getWeight_limit());
        entity.setMedications(dto.getMedications());
        return entity;
    }

    public DroneDto toDto(DroneEntity entity) {
        DroneDto dto=new DroneDto();
        dto.setBattery_capacity(entity.getBattery_capacity());
        dto.setModel(entity.getModel());
        dto.setState(entity.getState());
        dto.setSerial_number(entity.getSerial_number());
        dto.setWeight_limit(entity.getWeight_limit());
        dto.setMedications(entity.getMedications());
        return dto;
    }

}
