package com.example.demo.mapper;

import com.example.demo.dto.ClientDto;
import com.example.demo.dto.CreateVehicleRequest;
import com.example.demo.dto.VehicleDto;
import com.example.demo.model.Client;
import com.example.demo.model.Vehicle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface VehicleMapper {

    VehicleMapper INSTANCE = Mappers.getMapper(VehicleMapper.class);

    @Mapping(source = "id", target = "vehicleId")
    VehicleDto toDto(Vehicle vehicle);

    Vehicle toModel(CreateVehicleRequest vehicleRequest);

    List<VehicleDto> toDto(List<Vehicle> vehicles);

}
