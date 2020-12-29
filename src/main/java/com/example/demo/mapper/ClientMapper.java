package com.example.demo.mapper;

import com.example.demo.dto.ClientDto;
import com.example.demo.dto.CreateClientRequest;
import com.example.demo.model.Client;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClientMapper {

    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    ClientDto toDto(CreateClientRequest clientRequest);

    Client toModel(ClientDto clientDto);

    Client toModel(CreateClientRequest clientRequest);

}
