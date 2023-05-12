package com.example.demo.service;

import com.example.demo.dto.DroneDto;
import com.example.demo.entity.DroneEntity;
import com.example.demo.repository.DroneRepository;
import com.example.demo.service.serviceImpl.DroneServiceImpl;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.apache.catalina.connector.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;
import org.springframework.test.util.ReflectionTestUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@DisplayName("Test for Drone Service")
@ExtendWith(MockitoExtension.class)
public class DroneServiceTest {

    @Mock
    DroneRepository droneRepository;

    @InjectMocks
    DroneServiceImpl droneServiceImpl;

    @BeforeEach
    void setUp(){
        ReflectionTestUtils.setField(droneServiceImpl,"droneRepository",droneRepository);
    }

    @Test
    void whenGetDroneServiceImplThenReturnResponse()throws IOException {
        ObjectMapper objectMapper=new ObjectMapper();
        List<String> responseList=objectMapper.readValue(new File("./src/test/resources/response.json"),
                new TypeReference<>() {
                });

        List<DroneEntity> droneDataList=objectMapper.readValue(new File("./src/test/resources/drone-data.json"),
                new TypeReference<>() {
                });
        when(droneRepository.findAll()).thenReturn(droneDataList);
        

        List<String> expectedList = droneServiceImpl.checkAvailableDrone();
        Assertions.assertEquals(responseList,expectedList);

    }


}
