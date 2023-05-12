package com.example.demo.mapper;

import com.example.demo.dto.MedicationDto;
import com.example.demo.entity.MedicationEntity;
import org.springframework.stereotype.Component;

@Component
public class MedicationMapper {
    public MedicationEntity toEntity(MedicationDto dto) {
        MedicationEntity entity = new MedicationEntity();
        entity.setName(dto.getName());
        entity.setWeight(dto.getWeight());
        entity.setCode(dto.getCode());
        entity.setImage(dto.getImage());
        entity.setDroneSerialNumber(dto.getDroneSerialNumber());
        return entity;
    }

    public MedicationDto toDto(MedicationEntity entity) {
        MedicationDto dto = new MedicationDto();
        dto.setName(entity.getName());
        dto.setWeight(entity.getWeight());
        dto.setCode(entity.getCode());
        dto.setId(entity.getId());
        dto.setImage(entity.getImage());
        dto.setDroneSerialNumber(entity.getDroneSerialNumber());
        return dto;
    }
}
