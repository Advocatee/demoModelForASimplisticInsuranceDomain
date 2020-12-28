package com.example.demo.mapper;

import com.example.demo.dto.ClientDto;
import com.example.demo.dto.CreateClientRequest;
import com.example.demo.model.Clients;
import org.mapstruct.Mapper;

@Mapper
public interface EmployeeMapper {
    Clients clientToClientDto(ClientDto clientDto);
    ClientDto clientDtoToClientRequest(CreateClientRequest clientRequest);

}
