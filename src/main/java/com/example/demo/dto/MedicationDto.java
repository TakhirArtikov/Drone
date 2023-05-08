package com.example.demo.dto;

import lombok.Data;

@Data
public class MedicationDto {
    String name;
    Double weight;
    String code;
    String image;


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
