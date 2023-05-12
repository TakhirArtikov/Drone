package com.example.demo.controller;

import com.example.demo.dto.DroneDto;
import com.example.demo.dto.LoadDto;
import com.example.demo.dto.MedicationDto;
import com.example.demo.mapper.MedicationMapper;
import com.example.demo.repository.MedicationRepository;
import com.example.demo.service.serviceImpl.DroneServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/drone")
@AllArgsConstructor
public class DroneController {

    private final DroneServiceImpl droneService;
    private final MedicationRepository medicationRepository;
    private final MedicationMapper medicationMapper;


    @Operation(summary = "Drone register")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation",
                    content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = DroneDto.class))))
    })
    @PostMapping(value = "/register",produces = MediaType.APPLICATION_JSON_VALUE)
    public void registerDrone(@Valid @RequestBody DroneDto droneDto) {
        droneService.register(droneDto);
    }

    @Operation(summary = "Loading medication to drone")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation",
                    content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = MedicationDto.class))))
    })
    @PostMapping("/load")
    public void load(@RequestBody MedicationDto dto) {
        droneService.load(dto);
    }

    @Operation(summary = "Checking available drone which returns list of dron ids")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation",
                    content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = String.class))))
    })
    @GetMapping("/checkAvailableDrone")
    public ResponseEntity<List<String>> checkAvailableDrone() {
        List<String> list = droneService.checkAvailableDrone();
        return ResponseEntity.ok(list);
    }

    @Operation(summary = "Checking medication items for the given drone")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation",
                    content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = MedicationDto.class))))
    })
    @GetMapping("/checkMedicationItems/{serialNumber}")
    public List<MedicationDto> checkMedicationItems(@PathVariable String serialNumber) {
        return droneService.checkMedicationItems(serialNumber);
    }

    @Operation(summary = "Get battery level of the given drone")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation",
                    content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Double.class))))
    })
    @GetMapping("/getBatteryLevel/{serialNumber}")
    public Double getBatteryLevel(@PathVariable String serialNumber) {
        return droneService.getBatteryLevel(serialNumber);
    }
}
