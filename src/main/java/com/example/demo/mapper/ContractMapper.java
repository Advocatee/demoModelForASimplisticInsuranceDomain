package com.example.demo.mapper;

import com.example.demo.dto.ContractDto;
import com.example.demo.dto.CreateContractRequest;
import com.example.demo.model.Contract;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ContractMapper {

    ContractMapper INSTANCE = Mappers.getMapper(ContractMapper.class);

    Contract toModel(CreateContractRequest contractRequest);

    ContractDto toDto(Contract contract);

}
