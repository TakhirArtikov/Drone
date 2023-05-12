package com.example.demo.dto;

import com.example.demo.entity.MedicationEntity;
import com.example.demo.enums.DroneModel;
import com.example.demo.enums.DroneState;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class DroneDto {
    @NotBlank
    @Size(max = 100)
    private String serialNumber;

    private DroneModel model;
    @NotNull
    @Max(500)
    private Double weightLimit;
    @NotNull
    @Max(100)
    private Double batteryCapacity;

    private DroneState state;

    private List<MedicationEntity> medications;

}
