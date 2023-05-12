package com.example.demo.service.serviceImpl;

import com.example.demo.dto.DroneDto;
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
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @SneakyThrows
    @Override
    public void load(MedicationDto dto) {
        MedicationEntity medicationEntity = medicationMapper.toEntity(dto);
        Optional<DroneEntity> droneEntity = Optional.ofNullable(droneRepository.findBySerialNumber(dto.getDroneSerialNumber()));
        if (droneEntity.isPresent()) {
            if ((getDroneWeightSum(droneEntity.get().getSerialNumber()) + medicationEntity.getWeight()) < 500 && droneEntity.get().getBatteryCapacity() >= 25
                    && (droneEntity.get().getState().equals(DroneState.IDLE) || droneEntity.get().getState().equals(DroneState.LOADING))) {
                droneEntity.get().setState(DroneState.LOADING);

                if (getDroneWeightSum(droneEntity.get().getSerialNumber()) == 500) {
                    droneEntity.get().setState(DroneState.LOADED);
                    droneRepository.save(droneEntity.get());
                } else {
                    droneEntity.get().setState(DroneState.IDLE);
                    droneRepository.save(droneEntity.get());
                }
                medicationRepository.save(medicationEntity);
            } else {
                throw new IllegalArgumentException("Drone is not loaded because of conditions in if case !");
            }
        }else {
            throw new IllegalArgumentException("Drone is not registered yet !");
        }
    }

    @Override
    public List<String> checkAvailableDrone() {
        List<String> droneIdList=new ArrayList<>();
        List<DroneEntity> entities =droneRepository.findAll();
        for (DroneEntity drone : entities) {
            if (drone.getState().equals(DroneState.IDLE)) {
                droneIdList.add(drone.getSerialNumber());
            }
        }

        return droneIdList.stream().toList();
    }

    @Override
    public List<MedicationDto> checkMedicationItems(String serialNumber) {

        DroneEntity entity = droneRepository.findBySerialNumber(serialNumber);
        List<MedicationEntity> medications = entity.getMedications();

        List<MedicationDto> dtos = new ArrayList<>();
        for (MedicationEntity medication : medications) {
            dtos.add(medicationMapper.toDto(medication));
        }

        return dtos;
    }

    @Override
    public Double getBatteryLevel(String serialNumber) {

        DroneEntity entity = droneRepository.findBySerialNumber(serialNumber);
        return entity.getBatteryCapacity();
    }

    private Double getDroneWeightSum(String serialNumber) {
        Double sum = 0.0;
        DroneEntity entity = droneRepository.findBySerialNumber(serialNumber);
        List<MedicationEntity> medications = new ArrayList<>(entity.getMedications());
        for (Double w : medications.stream().map(MedicationEntity::getWeight).toList()) {
            sum += w;
        }
        return sum;
    }
}
