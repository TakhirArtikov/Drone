package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class DroneBatteryHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String serialNumber;
    @Column
    private Double batteryLevel;
    @Column
    private LocalDateTime dateTime;
}
