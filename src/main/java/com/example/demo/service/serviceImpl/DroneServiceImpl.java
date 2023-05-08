package com.example.demo.service.serviceImpl;

import com.example.demo.dto.DroneDto;
import com.example.demo.dto.LoadDto;
import com.example.demo.dto.MedicationDto;
import com.example.demo.entity.DroneEntity;
import com.example.demo.entity.MedicationEntity;
import com.example.demo.enums.DroneState;
import com.example.demo.mapper.DroneMapper;
import com.example.demo.mapper.MedicationMapper;
import com.example.demo.repository.DroneRepository;
import com.example.demo.repository.MedicationRepository;
import com.example.demo.service.DroneService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class DroneServiceImpl implements DroneService {

    private final DroneRepository droneRepository;
    private final MedicationRepository medicationRepository;
    private final DroneMapper droneMapper;
    private final MedicationMapper medicationMapper;

    @Override
    public void register(DroneDto dto) {
        DroneEntity entity = droneMapper.toEntity(dto);
        droneRepository.save(entity);
    }

    @Override
    public void load(LoadDto dto) {
        DroneEntity entity = droneRepository.findBySerialNumber(dto.getDroneSerialNumber());
        MedicationEntity medicationEntity = medicationRepository.findById(dto.getMedicationId()).get();

        if ((getDroneWeightSum(dto.getDroneSerialNumber()) + medicationEntity.getWeight()) < 500 && entity.getBattery_capacity() >= 25
                && (entity.getState().equals(DroneState.IDLE) || entity.getState().equals(DroneState.LOADING))) {
            entity.setState(DroneState.LOADING);
            entity.setMedications((List<MedicationEntity>) medicationEntity);
            if (entity.getWeight_limit() == 500) {
                entity.setState(DroneState.LOADED);
            } else {
                entity.setState(DroneState.IDLE);
            }
            droneRepository.save(entity);
        }

    }

    @Override
    public List<DroneDto> checkAvailableDrone() {
        List<DroneDto> dtos = new ArrayList<>();
        List<DroneEntity> entities = (List<DroneEntity>) droneRepository.findAll();
        for (DroneEntity drone : entities) {
            if (drone.getState().equals(DroneState.IDLE)) {
                dtos.add(droneMapper.toDto(drone));
            }
        }

        return dtos;
    }

    @Override
    public MedicationDto checkMedicationItems(String serialNumber) {

        DroneEntity entity = droneRepository.findBySerialNumber(serialNumber);
        List<MedicationEntity> medications = entity.getMedications();

        List<MedicationDto> dtos = new ArrayList<>();
        for (MedicationEntity medication : medications) {
            dtos.add(medicationMapper.toDto(medication));
        }

        return (MedicationDto) dtos;
    }

    @Override
    public Double getBatteryLevel(String serialNumber) {

        DroneEntity entity = droneRepository.findBySerialNumber(serialNumber);
        Double battery = entity.getBattery_capacity();
        return battery;
    }

    private Double getDroneWeightSum(String serialNumber) {
        Double sum = 0.0;
        DroneEntity entity = droneRepository.findBySerialNumber(serialNumber);
        List<MedicationEntity> medications = new ArrayList<>();
        for (MedicationEntity medication : entity.getMedications()) {
            medications.add(medication);
        }
        for (Double w : medications.stream().map(MedicationEntity::getWeight).toList()) {
            sum += w;
        }
        return sum;
    }
}
