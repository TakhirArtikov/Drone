package com.example.demo.dto;

import com.example.demo.entity.MedicationEntity;
import com.example.demo.enums.DroneModel;
import com.example.demo.enums.DroneState;
import lombok.Data;

import javax.validation.constraints.Size;
import java.util.List;

@Data
public class DroneDto {
    @Size(max = 100)
    private String serial_number;

    private DroneModel model;

    @Size(max = 500)
    private Double weight_limit;

    @Size(max = 100)
    private Double battery_capacity;

    private DroneState state;

    private List<MedicationEntity> medications;

}
