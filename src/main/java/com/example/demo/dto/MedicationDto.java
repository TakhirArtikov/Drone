package com.example.demo.dto;

import com.example.demo.entity.DroneEntity;
import lombok.Data;

@Data
public class MedicationDto {
    private Long id;
    private String name;
    private Double weight;
    private String code;
    private String image;
    private DroneEntity drone;


    public void setName(String name) {
        if (isValidName(name)) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Invalid name");
        }
    }

    public void setCode(String code) {
        if (isValidCode(code)) {
            this.code = code;
        } else {
            throw new IllegalArgumentException("Invalid code");
        }

    }

    public boolean isValidName(String name) {
        String regex = "^[a-zA-Z0-9_-]+$";
        return name.matches(regex);
    }

    public boolean isValidCode(String code) {
        String regex = "^[A-Z0-9_]+$";
        return code.matches(regex);
    }
}
