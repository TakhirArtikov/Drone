package com.example.demo.mapper;

import com.example.demo.dto.MedicationDto;
import com.example.demo.entity.MedicationEntity;

public class MedicationMapper {
    public MedicationEntity toEntity(MedicationDto dto) {
        MedicationEntity entity = new MedicationEntity();
        entity.setName(dto.getName());
        entity.setWeight(dto.getWeight());
        entity.setCode(dto.getCode());
        entity.setId(dto.getId());
        entity.setImage(dto.getImage());

        return entity;
    }

    public MedicationDto toDto(MedicationEntity entity) {
        MedicationDto dto = new MedicationDto();
        dto.setName(entity.getName());
        dto.setWeight(entity.getWeight());
        dto.setCode(entity.getCode());
        dto.setId(entity.getId());
        dto.setImage(entity.getImage());
        return dto;
    }
}
